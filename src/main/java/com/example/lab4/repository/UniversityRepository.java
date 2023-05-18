package com.example.lab4.repository;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.University;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityRepository {
    ArrayList<University> universities = new ArrayList<>();

    public University getUniversity(int index){
        return universities.get(index);
    }

    public University createUniversity(University university){
       return university;
    }
    public void addUniversity(University university){
        universities.add(university);
    }
    public List<University> getUniversities() {
        return universities;
    }
    public void addFacultyToUniversity(int index, Faculty faculty){
        getUniversity(index).getFaculty().add(faculty);
    }

}
