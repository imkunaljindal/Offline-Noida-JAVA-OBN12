package com.example.studentManagementApp.service;

import com.example.studentManagementApp.exceptions.StudentNotFoundException;
import com.example.studentManagementApp.model.Student;
import com.example.studentManagementApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(int id) {
       Student student = studentRepository.getStudentById(id);
       if(student==null) {
           throw new StudentNotFoundException("Student with id: "+id+ " not found.");
       }
       return student;
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
