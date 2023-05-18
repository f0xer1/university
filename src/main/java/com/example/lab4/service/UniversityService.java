package com.example.lab4.service;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.University;
import com.example.lab4.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository repository;
    public boolean verificationUniquenessUniversity(University university){
        for (University universityLoop: repository.getUniversities()){
            if (university.getUniversityName().equals(universityLoop.getUniversityName())) return true;
        }
        return false;
    }

    public University getUniversity(int index) {
        return repository.getUniversity(index);
    }
    public void addUniversity(University university){
        repository.addUniversity(university);
    }

    public University createUniversity() {
       return repository.createUniversity(new University());
    }

    public List<University> getUniversities() {
        return repository.getUniversities();
    }

    public void addFacultyToUniversity(String universityId, Faculty faculty) {
        repository.addFacultyToUniversity(getIndexFromId(universityId), faculty);
    }
    public University getUniversityById( String id){
        return getUniversity(getIndexFromId(id));
    }
    public List<Faculty> getFacultiesByUniversity(University university){
        return  university.getFaculty();
    }
    public int getIndexFromId(String id) {
        for (int i = 0; i < getUniversities().size(); i++) {
            if (getUniversity(i).getId().equals(id)) return i;
        }
        return -1000;
    }

}
