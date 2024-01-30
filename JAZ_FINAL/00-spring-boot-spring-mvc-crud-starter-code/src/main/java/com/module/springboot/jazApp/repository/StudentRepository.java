package com.module.springboot.jazApp.repository;

import com.module.springboot.jazApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findById(int studentId);
}
