package com.example.studentManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {
    private int id;
    private String name;
    private int salary;
    private String course;
}
