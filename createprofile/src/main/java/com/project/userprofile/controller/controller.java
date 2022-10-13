package com.project.userprofile.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.userprofile.model.*;
import com.project.userprofile.repository.*;
@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api/v3")
public class controller {
    @Autowired
    private repository repository;
    @GetMapping("/signup")
    public List < userprofile > getsignups() {
        return repository.findAll();
    }
    @GetMapping("/signup/{id}")
    public ResponseEntity < userprofile > getsignupById(
        @PathVariable(value = "id") Long signupId) throws ResourceNotFoundException {
        userprofile user = repository.findById(signupId)
            .orElseThrow(() -> new ResourceNotFoundException("signup not found :: " + signupId));
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/signup")
    public userprofile createUser(@Valid @RequestBody userprofile signup) {
        return repository.save(signup);
    }
    @PutMapping("/signup/{id}")
    public ResponseEntity < userprofile > updateUser(
        @PathVariable(value = "id") Long signupId,
        @Valid @RequestBody userprofile userDetails) throws ResourceNotFoundException {
        userprofile user = repository.findById(signupId)
            .orElseThrow(() -> new ResourceNotFoundException("signup not found :: " + signupId));
        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setUsername(userDetails.getUsername());
        user.setemail(userDetails.getemail()) ;
        user.setcontactno(userDetails.getcontactno());
        user.setDob(userDetails.getDob());
        user.setGender(userDetails.getGender());
        user.setCity(userDetails.getCity()) ;  
        final userprofile updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/signup")
    public void deleteUser(@Valid @RequestBody userprofile signup) {
         repository.delete(signup);
    }
    @DeleteMapping("/signup/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Long userprofileId) throws ResourceNotFoundException {
        userprofile signup = repository.findById(userprofileId)
            .orElseThrow(() -> new ResourceNotFoundException("signup not found :: " + userprofileId));
        repository.delete(signup);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}