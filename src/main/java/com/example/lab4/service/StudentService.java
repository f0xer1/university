package com.example.lab4.service;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.Student;
import com.example.lab4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student createStudent(){
        return studentRepository.createFaculty(new Student()) ;
    }
}
