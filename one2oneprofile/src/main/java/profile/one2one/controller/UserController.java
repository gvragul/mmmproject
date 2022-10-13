package profile.one2one.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import profile.one2one.model.User;


import profile.one2one.controller.ResourceNotFoundException;
import profile.one2one.repository.userrepository;
 
@RestController
@RequestMapping("/api/v1")
public class UserController {
 
    @Autowired
    private userrepository repository;
 

    @GetMapping("/profile")
    public List < User > getusers() {
        return repository.findAll();
    }
 
    @GetMapping("/profile/{id}")
    public ResponseEntity < User > getuserById(
        @PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        User user = repository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found :: " + userId));
        return ResponseEntity.ok().body(user);
    }
 
    @PostMapping("/profile")
    public User createUser(@Valid @RequestBody User user) {
        return repository.save(user);
    }
 
    @PutMapping("/profile/{id}")
    public ResponseEntity < User > updateUser(
        @PathVariable(value = "id") Integer userId,
        @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = repository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found :: " + userId));
        user.setUserId(userDetails.getUserId());
        user.setPassWord(userDetails.getPassWord());
        
        user.setcreateprofile(userDetails.getcreateprofile()) ;    
        
        final User updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
 
    @DeleteMapping("/profile/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        User user = repository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found :: " + userId));
 
        repository.delete(user);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}