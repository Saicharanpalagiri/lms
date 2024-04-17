package com.lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lms.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>{
    
}
