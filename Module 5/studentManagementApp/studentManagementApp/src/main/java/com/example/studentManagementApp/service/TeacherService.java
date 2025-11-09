package com.example.studentManagementApp.service;

import com.example.studentManagementApp.model.Teacher;
import com.example.studentManagementApp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public String addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }
}
