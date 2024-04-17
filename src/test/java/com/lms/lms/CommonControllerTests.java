package com.lms.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lms.lms.models.Student;
import com.lms.lms.models.Subject;
import com.lms.lms.services.CommonServiceImpl;
import com.lms.lms.services.ExamServiceImpl;
import com.lms.lms.services.StudentServiceImpl;
import com.lms.lms.services.SubjectServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CommonControllerTests {
    @Mock
    private StudentServiceImpl studentService;

    @Mock
    private ExamServiceImpl examService;

    @Mock
    private SubjectServiceImpl subjectService;

    @InjectMocks
    private CommonServiceImpl commonService;

    @Test
    public void testEnrollStudentInSubject_Success() {
        // Mocking the behavior of studentService.getStudentById() and subjectService.getSubjectById()
        Student student = new Student();
        student.setId(1L);
        Subject subject = new Subject();
        subject.setId(1L);
        when(studentService.getStudentById(1L)).thenReturn(student);
        when(subjectService.getSubjectById(1L)).thenReturn(subject);
        when(studentService.saveStudent(student)).thenReturn(student);
        when(subjectService.saveSubject(subject)).thenReturn(subject);
        Student result = commonService.enrollStudentInSubject(1L, 1L);
        assertNotNull(result);
        assertEquals(1, result.getEnrolledSubjects().size());
        assertTrue(result.getEnrolledSubjects().contains(subject));
        verify(studentService, times(1)).saveStudent(student);
        verify(subjectService, times(1)).saveSubject(subject);
    }
}
