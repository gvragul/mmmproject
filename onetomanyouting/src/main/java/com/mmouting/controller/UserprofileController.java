package com.mmouting.controller;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mmouting.bean.Outing;
import com.mmouting.bean.Userprofile;
import com.mmouting.repository.OutingRepository;
import com.mmouting.repository.UserprofileRepository;



@RestController
@RequestMapping("/api")
public class UserprofileController {

    @Autowired
    private UserprofileRepository userRepository;

    @Autowired
    private OutingRepository outingRepository;

    @GetMapping("/outing/{outingId}/users")
    public List < Userprofile > getUserprofileByOuting(@PathVariable(value = "outingId") Integer outingId) {
        return userRepository.findByOutingId(outingId);
    }
   @GetMapping(value="/outing/{outingId}/users/{userId}")
    public ResponseEntity < Userprofile > getById(
        @PathVariable(value = "userId") Integer userId) throws ResourceNotFoundException {
    	Userprofile user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found :: " + userId));
        return ResponseEntity.ok().body(user);
    } 

    @PostMapping("/outing/{outingId}/users")
    public Userprofile createCourse(@PathVariable(value = "outingId") Integer outingId,
        @Validated @RequestBody Userprofile user) throws ResourceNotFoundException {
        return outingRepository.findById(outingId).map(outing -> {
            user.setOuting(outing);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("outing not found"));
    }
    
    @PutMapping("/outing/{outingId}/users/{userId}")
    public ResponseEntity < Userprofile > updateUser(
            @PathVariable(value = "userId") Integer userId,
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
        
  /*  @DeleteMapping("/outing/{outingId}/users/{userId}")
    public ResponseEntity<String> deleteUserprofile(@PathVariable(name = "userId") Integer userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } */
    @DeleteMapping("/outing/{outingId}/users/{userId}")
    public ResponseEntity<Userprofile> deleteUserprofile(@PathVariable("userId") Integer userId) {
      userRepository.deleteById(userId);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }  
   
}

   
