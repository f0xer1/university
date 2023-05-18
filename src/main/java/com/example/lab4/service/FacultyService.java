package com.example.lab4.service;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.Student;
import com.example.lab4.entity.University;
import com.example.lab4.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
     FacultyRepository facultyRepository;
    @Autowired
    UniversityService universityService;
    public boolean verificationUniquenessFaculty(Faculty faculty, String universytyId){
        for ( Faculty facultyLoop: universityService.getUniversityById(universytyId).getFaculty()){
            if (faculty.getFacultyName().equals(facultyLoop.getFacultyName())) return true;
        }
        return false;
    }
    public Faculty createFaculty(){
        return facultyRepository.createFaculty(new Faculty()) ;
    }
    public void addStudentToFaculty(String facultyId, University university, Student student){

        facultyRepository.addStudentToFaculty(getIndexFromId(facultyId,university), university,student);
    }
    public int getIndexFromId(String id, University university) {
        for (int i = 0; i < university.getFaculty().size(); i++) {
            if (university.getFaculty().get(i).getId().equals(id)) return i;
        }
        return -1000;
    }

}
