package com.example.studentManagementApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    HashMap<Integer, Student> studentDb = new HashMap<>();

    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome Student";
    }

    @GetMapping("/student")
    public Student getStudentById(@RequestParam("id") int id) {
        if(!studentDb.containsKey(id)) {
            return null;
        }
        return studentDb.get(id);
    }
}
