package com.mmsports.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.mmsports.bean.Sports;
import com.mmsports.repository.SportsRepository;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/vi")
public class SportsController {
    @Autowired
    private SportsRepository sportsrepository;
    @GetMapping("/Sports/")
    public ResponseEntity<List<Sports>> getCustomers() {
        List<Sports> accounts = sportsrepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PostMapping("/Sports/")
    public ResponseEntity<Sports> createAccount(@RequestBody Sports account) {
        Sports acnt = sportsrepository.save(account);
        return new ResponseEntity<>(acnt, HttpStatus.OK);
    }
    @PutMapping("/Sports/")
    public ResponseEntity<Sports> updateAccount(@RequestBody Sports company) {
        Optional<Sports> acnt = sportsrepository.findById(company.getId());
        Sports acntUpdated = acnt.get();
        acntUpdated.setSportname(company.getSportname());
        acntUpdated.setGroupname(company.getGroupname());
        acntUpdated.setMembersrequired(company.getMembersrequired());
        acntUpdated.setDate(company.getDate());
        acntUpdated.setPlace(company.getPlace());
        acntUpdated.setTime(company.getTime());
        acntUpdated.setLocation(company.getLocation());
        acntUpdated.setLanguage(company.getLanguage());
     
        Sports customerUpdated = sportsrepository.save(acntUpdated);
        return new ResponseEntity<>(customerUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/Sports/{id}")
    public ResponseEntity<String> createStudent(@PathVariable(name = "id") Long id) {
        sportsrepository.deleteById(id);
        return new ResponseEntity<>("outing no "+ id + " deleted successfully", HttpStatus.OK);
    }
}
