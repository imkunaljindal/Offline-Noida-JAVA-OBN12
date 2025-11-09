package com.example.studentManagementApp.controller;

import com.example.studentManagementApp.exceptions.StudentNotFoundException;
import com.example.studentManagementApp.model.Student;
import com.example.studentManagementApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome Student";
    }

    @GetMapping
    public ResponseEntity getStudentById(@RequestParam("id") int id) {
        try{
           return new ResponseEntity(studentService.getStudentById(id), HttpStatus.OK);
        }
        catch (StudentNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentByIdPath(@PathVariable("id") int id) {
       return studentService.getStudentById(id);
    }

    @PutMapping("/id/{id}/age/{age}")
    public String updateAge(@PathVariable("id") int id,
                            @PathVariable("age") int age) {
        return studentService.updateAge(id, age);
    }

    @PutMapping
    public String updateAgeByRequestParam(@RequestParam("id") int id,
                            @RequestParam("age") int age) {
        return studentService.updateAge(id,age);
    }

    // Get the list of all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Delete a student
    @DeleteMapping
    public String deleteStudent(@RequestParam("id") int id) {
        return studentService.deleteStudent(id);
    }
}
