package com.example.studentManagementApp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<Integer, Student> studentDb = new HashMap<>();

    public Student getStudentById(int id) {
        if(!studentDb.containsKey(id)) {
            return null;
        }
        return studentDb.get(id);
    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getId())) {
            return "Student already added";
        }
        studentDb.put(student.getId(),student);
        return "Student added successfully";
    }

    public String updateAge(int id, int age) {
        if(!studentDb.containsKey(id)) {
            return "Invalid id";
        }
        Student existingStudent = studentDb.get(id);
        existingStudent.setAge(age);
        studentDb.put(id,existingStudent);
        return "Age updated successfully";
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDb.values());
    }

    public String deleteStudent(int id) {
        if(!studentDb.containsKey(id)) {
            return "Imvalid id";
        }
        studentDb.remove(id);
        return "Student deleted successfully";
    }
}
