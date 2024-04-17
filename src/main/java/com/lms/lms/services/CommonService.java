package com.lms.lms.services;

import com.lms.lms.models.Student;

public interface CommonService {
    Student enrollStudentInSubject(long studentId, long subjectId);
    Student enrollStudentInExam(long studentId, long examId);
}
