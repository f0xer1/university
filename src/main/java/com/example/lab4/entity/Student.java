package com.example.lab4.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    @NotEmpty(message = "Введіть ім'я")
    private String name;
    @NotEmpty(message = "Введіть прізвище")
    private String surname;
    @NotNull(message = "Номер залікової книжки повинен бути заданий")
    @Min(value = 1, message = "Номер залікової книжки повинен бути більше 1")
    private Integer numberOfTheScoreBook;

    @NotNull(message = "Бал повинен бути заданий")
    @Min(value = 1, message = "Бал повинен бути більше 1 і менше 100")
    @Max(value = 100, message = "Бал повинен бути більше 1 і менше 100")
    private Integer gpa;


    public Student() {
    }

    @Override
    public String toString() {
        return  name + " " + surname + " " + " gpa=" + gpa ;
    }
}
