package com.lms.lms.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lms.models.Exam;
import com.lms.lms.models.Student;
import com.lms.lms.models.Subject;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private ExamServiceImpl examService;
    @Autowired
    private SubjectServiceImpl subjectService;

    @Override
    public Student enrollStudentInSubject(long studentId, long subjectId) {
        Student student=studentService.getStudentById(studentId);
        Subject subject = subjectService.getSubjectById(subjectId);
        if(student.getEnrolledSubjects()==null){
            student.setEnrolledSubjects(new ArrayList<>());
        }
        if(subject.getRegisteredStudents()==null){
            subject.setRegisteredStudents(new ArrayList<>());
        }
        if(student.getEnrolledSubjects().contains(subject)){
            throw new RuntimeException("Student already enrolled for subject");
        //    return new ResponseEntity<>("User already enrolled for the subject requested", HttpStatus.BAD_REQUEST);
        }
        student.getEnrolledSubjects().add(subject);
        subject.getRegisteredStudents().add(student);
        studentService.saveStudent(student);
        subjectService.saveSubject(subject);
        return student;
    }

    @Override
    public Student enrollStudentInExam(long studentId, long examId) {
        // TODO Auto-generated method stub
        Student student=studentService.getStudentById(studentId);
        Exam exam=examService.getExamById(examId);
        Subject subject=exam.getSubject();
        if(!student.getEnrolledSubjects().contains(subject)){
            // return new ResponseEntity<>("Student is not enrolled to take part in exam as he is not enrolled for the subject",
            //  HttpStatus.BAD_REQUEST);
            throw new RuntimeException("Student is not enrolled for the subject");
        }
        if(student.getRegisteredExams().contains(exam)){
            // return new ResponseEntity<>("Student is already enrolled for the exam requested",
            //  HttpStatus.BAD_REQUEST);
            throw new RuntimeException("Student is already enrolled for the exam requested");
        }
        student.getRegisteredExams().add(exam);
        exam.getEnrolledStudents().add(student);
        studentService.saveStudent(student);
        examService.saveExam(exam);
        return student;
    }
    
}
