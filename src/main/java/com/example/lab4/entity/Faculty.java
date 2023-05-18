package com.example.lab4.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class Faculty {
    @NotEmpty(message = "Введіть назву факультету")
    private String facultyName;
    private ArrayList<Student> students = new ArrayList<>();
    private String id;

    public Faculty() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "faculty='" + facultyName + '\'' +
                ", students=" + students +
                '}';

    }
}
