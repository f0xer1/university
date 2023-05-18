package com.example.lab4.repository;

import com.example.lab4.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student createFaculty(Student student){
        return student;
    }
}
