package com.lms.lms.services;

import java.util.List;

import com.lms.lms.models.Exam;

public interface ExamService {
    List<Exam> getAllExams();
    Exam getExamById(Long id);
    Exam saveExam(Exam exam);
    void deleteExam(Long id);
}
