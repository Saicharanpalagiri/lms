package com.lms.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lms.services.StudentService;
import com.lms.lms.services.StudentServiceImpl;
import java.util.List;

import com.lms.lms.models.Student;

@RestController
@RequestMapping("api/students")
public class StudentController {
    
    @Autowired
    private StudentServiceImpl studentServiceImpl;
    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> students= studentServiceImpl.getAllStudents();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student=studentServiceImpl.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student createdStudent=studentServiceImpl.saveStudent(student);
        return new ResponseEntity(createdStudent, HttpStatus.CREATED);
    } 


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentServiceImpl.deleteStudent(id);
    }
}
