package com.example.lab4.repository;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.Student;
import com.example.lab4.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyRepository {
    @Autowired
    UniversityRepository universityService;
    public Faculty createFaculty(Faculty faculty){
        return faculty;
    }

    public void addStudentToFaculty(int facultyIndex, University university, Student student){
        university.getFaculty().get(facultyIndex).getStudents().add(student);
    }

}
