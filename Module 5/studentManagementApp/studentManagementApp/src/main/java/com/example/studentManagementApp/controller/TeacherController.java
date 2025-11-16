package com.example.studentManagementApp.controller;

import com.example.studentManagementApp.exceptions.TeacherExistsException;
import com.example.studentManagementApp.model.Teacher;
import com.example.studentManagementApp.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addTeacher(@RequestBody Teacher teacher) {
        try{
            log.info("Teacher input received: "+teacher);
            String response = teacherService.addTeacher(teacher);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (TeacherExistsException e) {
            log.error("Exception while adding teacher: "+e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
