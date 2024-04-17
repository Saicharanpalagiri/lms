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
    private StudentServiceImpl studentService;
    @Autowired
    private ExamServiceImpl examService;
    @Autowired
    private SubjectServiceImpl subjectService;
    @Autowired
    private CommonServiceImpl commonService;


    @PostMapping("subject")
    public ResponseEntity<?> enrollStudentInSubject(@RequestBody StudentSubjectDto studentSubjectDto){
        long studentId = studentSubjectDto.getStudentId();
        long subjectId = studentSubjectDto.getSubjectId();
        // Student student=studentService.getStudentById(studentId);
        // Subject subject = subjectService.getSubjectById(subjectId);
        // if(student.getEnrolledSubjects()==null){
        //     student.setEnrolledSubjects(new ArrayList<>());
        // }
        // if(subject.getRegisteredStudents()==null){
        //     subject.setRegisteredStudents(new ArrayList<>());
        // }
        // if(student.getEnrolledSubjects().contains(subject)){
        //    return new ResponseEntity<>("User already enrolled for the subject requested", HttpStatus.BAD_REQUEST);
        // }
        // student.getEnrolledSubjects().add(subject);
        // subject.getRegisteredStudents().add(student);
        // studentService.saveStudent(student);
        // subjectService.saveSubject(subject);
        Student student=commonService.enrollStudentInSubject(studentId, subjectId);
        return new ResponseEntity(student,HttpStatus.ACCEPTED);
    }

    @PostMapping("exam")
    public ResponseEntity<?> enrollExam(@RequestBody StudentExamDto studentExamDto) {
        long studentId=studentExamDto.getStudentId();
        long examId=studentExamDto.getExamId();
        // Student student=studentService.getStudentById(studentId);
        // Exam exam=examService.getExamById(examId);
        // Subject subject=exam.getSubject();
        // if(!student.getEnrolledSubjects().contains(subject)){
        //     return new ResponseEntity<>("Student is not enrolled to take part in exam as he is not enrolled for the subject",
        //      HttpStatus.BAD_REQUEST);
        // }
        // if(student.getRegisteredExams().contains(exam)){
        //     return new ResponseEntity<>("Student is already enrolled for the exam requested",
        //      HttpStatus.BAD_REQUEST);
        // }
        // student.getRegisteredExams().add(exam);
        // exam.getEnrolledStudents().add(student);
        // studentService.saveStudent(student);
        // examService.saveExam(exam);
        Student student=commonService.enrollStudentInExam(studentId, examId);
      return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    
}
