package com.module.springboot.jazApp.service.implementation;


import com.module.springboot.jazApp.entity.Student;
import com.module.springboot.jazApp.repository.StudentRepository;
import com.module.springboot.jazApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student findById(int studentId) {return studentRepository.findById(studentId);}



}
