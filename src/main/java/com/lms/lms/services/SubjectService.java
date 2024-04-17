package com.lms.lms.services;

import java.util.List;
import com.lms.lms.models.Subject;

public interface SubjectService {
    List<Subject> getAllSubjects(); 
    Subject getSubjectById(Long id);
    Subject saveSubject(Subject subject);
    void deleteSubject(Long id);
}
