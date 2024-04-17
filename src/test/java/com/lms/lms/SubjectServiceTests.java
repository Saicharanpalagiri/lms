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

import com.lms.lms.models.Subject;
import com.lms.lms.repository.SubjectRepository;
import com.lms.lms.services.SubjectServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTests {
 
    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectService;


    @Test
    public void testGetSubjectById_ThrowsException() {
        when(subjectRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> subjectService.getSubjectById(1L));
    }


    @Test
    public void testSaveSubject() {
        Subject subject = new Subject();
        subject.setName("History");
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject savedSubject = subjectService.saveSubject(subject);
        assertEquals("History", savedSubject.getName());
        // verify(subjectRepository, times(1)).save(subject);
    }

    @Test
    public void testGetAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1L, "Maths"));
        subjects.add(new Subject(2L, "Science"));
        when(subjectRepository.findAll()).thenReturn(subjects);
        List<Subject> result = subjectService.getAllSubjects();
        assertEquals(2, result.size());
        assertEquals("Maths", result.get(0).getName());
        assertEquals("Science", result.get(1).getName());
    }
}
