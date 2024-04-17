package com.lms.lms.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lms.dtos.StudentExamDto;
import com.lms.lms.dtos.StudentSubjectDto;
import com.lms.lms.models.Exam;
import com.lms.lms.models.Student;
import com.lms.lms.models.Subject;
import com.lms.lms.services.CommonServiceImpl;
import com.lms.lms.services.ExamService;
import com.lms.lms.services.ExamServiceImpl;
import com.lms.lms.services.StudentService;
import com.lms.lms.services.StudentServiceImpl;
import com.lms.lms.services.SubjectServiceImpl;

@RestController
@RequestMapping("/api/enroll")
public class CommonController {

    @Autowired
    private CommonServiceImpl commonService;


    @PostMapping("subject")
    public ResponseEntity<?> enrollStudentInSubject(@RequestBody StudentSubjectDto studentSubjectDto){
        long studentId = studentSubjectDto.getStudentId();
        long subjectId = studentSubjectDto.getSubjectId();
        Student student=commonService.enrollStudentInSubject(studentId, subjectId);
        return new ResponseEntity(student,HttpStatus.ACCEPTED);
    }

    @PostMapping("exam")
    public ResponseEntity<?> enrollExam(@RequestBody StudentExamDto studentExamDto) {
        long studentId=studentExamDto.getStudentId();
        long examId=studentExamDto.getExamId();
        Student student=commonService.enrollStudentInExam(studentId, examId);
      return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    
}
