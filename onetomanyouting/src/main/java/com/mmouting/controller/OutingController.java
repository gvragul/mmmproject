package com.mmouting.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.mmouting.repository.OutingRepository;





@RestController
@RequestMapping("/api")
public class OutingController {

    @Autowired
    private OutingRepository outingRepository;


    @GetMapping("/outing/")
    public List < Outing > getOuting() {
        return outingRepository.findAll();
    }

    @GetMapping("/outing/{id}")
    public ResponseEntity < Outing > getById(
        @PathVariable(value = "id") Integer outingId) throws ResourceNotFoundException {
        Outing user = outingRepository.findById(outingId)
            .orElseThrow(() -> new ResourceNotFoundException("outing not found :: " + outingId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/outing/")
    public Outing createUser(@Validated @RequestBody Outing outing) {
        return outingRepository.save(outing);
    }
    @PutMapping("/outing/")
    public ResponseEntity<Outing> updateAccount(@RequestBody Outing company) {
        Optional<Outing> acnt = outingRepository.findById(company.getId());
        Outing acntUpdated = acnt.get();
        acntUpdated.setType(company.getType());
        acntUpdated.setGroupname(company.getGroupname());
        acntUpdated.setMembersrequired(company.getMembersrequired());
        acntUpdated.setBudget(company.getBudget());
        acntUpdated.setAgelimit(company.getAgelimit());
        acntUpdated.setDate(company.getDate());
        acntUpdated.setPlace(company.getPlace());
        acntUpdated.setTime(company.getTime());
        acntUpdated.setLocation(company.getLocation());
        acntUpdated.setLanguage(company.getLanguage());
        acntUpdated.setGender(company.getGender());
        acntUpdated.setDuration(company.getDuration());
        Outing companiesUpdated = outingRepository.save(acntUpdated);
        return new ResponseEntity<>(companiesUpdated, HttpStatus.OK);
    }
  /*  @DeleteMapping("/outing/{id}")
    public ResponseEntity<String> deleteouting(@PathVariable(name = "id") Integer id) {
        outingRepository.deleteById(id);
        return new ResponseEntity<>("Account no: "+ id + " deleted successfully", HttpStatus.OK);
    } */
    @DeleteMapping("/outing/{id}")
    public ResponseEntity<HttpStatus> deleteOuting(@PathVariable("id") Integer id) {
      outingRepository.deleteById(id);
      
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

    
