package com.lms.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.lms.lms.models.Subject;

import com.lms.lms.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElseThrow(()->new RuntimeException("Subject not found"));
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
