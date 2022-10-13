package com.mmsports.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mmsports.bean.Sports;
import com.mmsports.bean.Userprofile;
import com.mmsports.repository.SportsRepository;
import com.mmsports.repository.UserprofileRepository;



@RestController
public class UserprofileController {

    @Autowired
    private UserprofileRepository userRepository;

    @Autowired
    private SportsRepository sportsRepository;

    @GetMapping("/sports/{sportsId}/users")
    public List < Userprofile > getUserprofileBySports(@PathVariable(value = "sportsId") Long sportsId) {
        return userRepository.findBySportsId(sportsId);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity < Userprofile > getById(
        @PathVariable(value = "userId") Long userId) throws ResourceNotFoundException {
    	Userprofile user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/sports/{sportsId}/users")
    public Userprofile createCourse(@PathVariable(value = "sportsId") Long sportsId,
        @Validated @RequestBody Userprofile user) throws ResourceNotFoundException {
        return sportsRepository.findById(sportsId).map(sports -> {
            user.setSports(sports);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("sports not found"));
    }@PutMapping("/user/{userId}")
    public ResponseEntity < Userprofile > updateUser(
            @PathVariable(value = "userId") Long userId,
            @Valid @RequestBody Userprofile userDetails) throws ResourceNotFoundException {
            Userprofile user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("signup not found :: " + userId));
            user.setName(userDetails.getName());
            user.setSurname(userDetails.getSurname());
            user.setUsername(userDetails.getUsername());
            user.setPhoneno(userDetails.getPhoneno()) ;
            user.setEmail(userDetails.getEmail());
            user.setDob(userDetails.getDob());
            user.setGender(userDetails.getGender());
            user.setCity(userDetails.getCity()) ;  
            final Userprofile updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        }
        
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUserprofile(@PathVariable(name = "userId") Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>("userid: "+ userId + " deleted successfully", HttpStatus.OK);
    }}

   
