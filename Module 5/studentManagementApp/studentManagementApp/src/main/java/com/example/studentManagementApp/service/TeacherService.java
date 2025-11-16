package com.example.studentManagementApp.service;

import com.example.studentManagementApp.controller.TeacherController;
import com.example.studentManagementApp.model.Teacher;
import com.example.studentManagementApp.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    Logger logger = LoggerFactory.getLogger(TeacherService.class);

    public String addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }
}
