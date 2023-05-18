package com.example.lab4.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class University {
    @NotEmpty(message = "Введіть назву університету")
    private String universityName;


    private ArrayList<Faculty> faculty = new ArrayList<>();
    private String id;
    public University() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return universityName;
    }
}
