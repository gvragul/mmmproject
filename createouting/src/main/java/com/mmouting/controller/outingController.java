package com.mmouting.controller;

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

import com.mmouting.bean.outing;
import com.mmouting.repository.OutingRepository;






@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class outingController {
    @Autowired
    private OutingRepository mmRepository;
    @GetMapping("/outing/")
    public ResponseEntity<List<outing>> getoutings() {
        List<outing> group = mmRepository.findAll();
        return new ResponseEntity<>(group, HttpStatus.OK);
    }
    @PostMapping("/outing/")
    public ResponseEntity<outing> createAccount(@RequestBody outing company) {
        outing acnt = mmRepository.save(company);
        return new ResponseEntity<>(acnt, HttpStatus.OK);
    }
    @PutMapping("/outing/")
    public ResponseEntity<outing> updateAccount(@RequestBody outing company) {
        Optional<outing> acnt = mmRepository.findById(company.getSno());
        outing acntUpdated = acnt.get();
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
        outing companiesUpdated = mmRepository.save(acntUpdated);
        return new ResponseEntity<>(companiesUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/outing/{sno}")
    public ResponseEntity<String> deleteouting(@PathVariable(name = "sno") Long sno) {
        mmRepository.deleteById(sno);
        return new ResponseEntity<>("Account no: "+ sno + " deleted successfully", HttpStatus.OK);
    }
}
