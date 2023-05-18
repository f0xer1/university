package com.example.lab4.task;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.Student;
import com.example.lab4.entity.University;

import java.util.ArrayList;
import java.util.Iterator;

public class Task {
    public static String doTask(University university, String task){
        if(task.equals("first")){
            return  totalStudent(university);
        } else if (task.equals("second")) {
            return getMostFacultyStudent(university);
        }else {
            return successfulStudents(university);
        }
    }

    public static String totalStudent(University university) {
    int totalStudent = 0;
    for (Iterator i = university.getFaculty().iterator(); i.hasNext(); ) {
        Faculty f = (Faculty) i.next();
        for (Iterator j = f.getStudents().iterator(); j.hasNext(); ) {
            Student s = (Student) j.next();
            totalStudent++;
        }
    }
    return  String.valueOf(totalStudent);
}
    public static String getMostFacultyStudent(University university) {
        int mostStudent = 0;
        Faculty faculty = null;
        for (Iterator<Faculty> i = university.getFaculty().iterator(); i.hasNext(); ) {
            Faculty f = i.next();
            int student = 0;
            for (Iterator<Student> j = f.getStudents().iterator(); j.hasNext(); ) {
                Student s = j.next();
                student++;
            }
            if (student >= mostStudent) {
                mostStudent = student;
                faculty = f;
            }
        }
        return faculty.getFacultyName();

    }

    public static String successfulStudents(University university) {
        ArrayList<Student> successfulStudents = new ArrayList<>();
        for (Faculty f : university.getFaculty()) {
            for (Student s : f.getStudents()) {
                if (s.getGpa()>=95){
                    successfulStudents.add(s);
                }
            }
        }
        return successfulStudents.toString();
    }
}
