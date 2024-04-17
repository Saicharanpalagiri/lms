package com.lms.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lms.models.Subject;
import com.lms.lms.services.SubjectServiceImpl;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @GetMapping
    public  ResponseEntity<List<Subject>> getAllSubjects(){
        List<Subject> subjects=subjectService.getAllSubjects();
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long id){
        Subject subject=subjectService.getSubjectById(id);
        return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject savedSubject= subjectService.saveSubject(subject);
        return new ResponseEntity(savedSubject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
    
}
