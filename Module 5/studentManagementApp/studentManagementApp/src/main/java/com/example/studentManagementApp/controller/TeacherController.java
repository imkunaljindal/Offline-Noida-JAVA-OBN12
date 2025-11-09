package com.example.studentManagementApp.controller;

import com.example.studentManagementApp.exceptions.TeacherExistsException;
import com.example.studentManagementApp.model.Teacher;
import com.example.studentManagementApp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addTeacher(@RequestBody Teacher teacher) {
        try{
           String response = teacherService.addTeacher(teacher);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (TeacherExistsException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
