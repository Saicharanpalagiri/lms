package com.lms.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.lms.models.Exam;
import com.lms.lms.models.Subject;
import com.lms.lms.repository.ExamRepository;
import com.lms.lms.services.ExamServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTests {
    @Mock
    private ExamRepository examRepository;

    @InjectMocks
    private ExamServiceImpl examService;

    @Test
    public void testGetExamById_ThrowsException() {
        when(examRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> examService.getExamById(1L));
    }

    @Test
    public void testSaveExam() {
        Exam exam = new Exam();
        Subject subject=new Subject(1L,"MATHS");
        exam.setSubject(subject);
        when(examRepository.save(exam)).thenReturn(exam);
        Exam savedExam = examService.saveExam(exam);
        assertEquals("MATHS", savedExam.getSubject().getName());
        // verify(examRepository, times(1)).save(exam);
    }

    @Test
    public void testGetAllExams() {
         new ArrayList<>();
        Exam exam1=new Exam();
        exam1.setSubject(new Subject(1L, "Maths"));
        Exam exam2=new Exam();
        exam2.setSubject(new Subject(2L, "Science"));
        List<Exam> exams =List.of(exam1,exam2);
        when(examRepository.findAll()).thenReturn(exams);
        List<Exam> result = examService.getAllExams();
        assertEquals(2, result.size());
        assertEquals("Maths", result.get(0).getSubject().getName());
        assertEquals("Science", result.get(1).getSubject().getName());
    }


}
