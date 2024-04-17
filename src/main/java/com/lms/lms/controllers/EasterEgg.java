package com.lms.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lms.services.EasterEggServiceImpl;

@RestController
@RequestMapping("hidden-feature")
public class EasterEgg {
    @Autowired
    private EasterEggServiceImpl easterEggService;
    
    @GetMapping("{number}")
    public ResponseEntity<?> getFacts(@PathVariable long number){
        String response=easterEggService.getFacts(number);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
