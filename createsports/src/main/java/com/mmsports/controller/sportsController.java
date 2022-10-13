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

import com.mmsports.bean.sports;
import com.mmsports.repository.SportsRepository;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/vi")
public class sportsController {
    @Autowired
    private SportsRepository BankRepository;
    @GetMapping("/sports/")
    public ResponseEntity<List<sports>> getCustomers() {
        List<sports> accounts = BankRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PostMapping("/sports/")
    public ResponseEntity<sports> createAccount(@RequestBody sports account) {
        sports acnt = BankRepository.save(account);
        return new ResponseEntity<>(acnt, HttpStatus.OK);
    }
    @PutMapping("/sports/")
    public ResponseEntity<sports> updateAccount(@RequestBody sports company) {
        Optional<sports> acnt = BankRepository.findById(company.getSno());
        sports acntUpdated = acnt.get();
        acntUpdated.setSportname(company.getSportname());
        acntUpdated.setGroupname(company.getGroupname());
        acntUpdated.setMembersrequired(company.getMembersrequired());
        acntUpdated.setDate(company.getDate());
        acntUpdated.setPlace(company.getPlace());
        acntUpdated.setTime(company.getTime());
        acntUpdated.setLocation(company.getLocation());
        acntUpdated.setLanguage(company.getLanguage());
     
        sports customerUpdated = BankRepository.save(acntUpdated);
        return new ResponseEntity<>(customerUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/sports/{sno}")
    public ResponseEntity<String> createStudent(@PathVariable(name = "sno") Long sno) {
        BankRepository.deleteById(sno);
        return new ResponseEntity<>("outing no "+ sno + " deleted successfully", HttpStatus.OK);
    }
}
