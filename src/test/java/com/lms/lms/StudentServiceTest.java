package com.lms.lms;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.lms.models.Student;
import com.lms.lms.repository.StudentRepository;
import com.lms.lms.services.StudentServiceImpl;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    // @BeforeAll
    // public void init() {
    //     MockitoAnnotations.initMocks(this);
    // }
    

    @Test
    public void testGetAllStudents() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John"));
        students.add(new Student(2L, "Alice"));
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
    @Test
    public void testGetStudentById_ThrowsException() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,  ()-> studentService.getStudentById(1L));
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student(1L, "John");
        when(studentRepository.save(student)).thenReturn(student);
        Student result = studentService.saveStudent(student);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }
}
