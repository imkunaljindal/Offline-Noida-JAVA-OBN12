package com.example.studentManagementApp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
     int id; // primary key
     String name;
     public int age;
     int marks;
}
