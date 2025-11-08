package com.example.studentManagementApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(int id) {
       return studentRepository.getStudentById(id);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String updateAge(int id, int age) {
        return studentRepository.updateAge(id, age);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}
