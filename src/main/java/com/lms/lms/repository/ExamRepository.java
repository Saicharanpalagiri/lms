package com.lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lms.models.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long>{
    
}
