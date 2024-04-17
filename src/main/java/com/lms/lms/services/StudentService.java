package com.lms.lms.services;

import java.util.List;

import com.lms.lms.models.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
}
