package com.example.studentManagementApp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {
    private int id;
    private String name;
    private int salary;
    private String course;
}
