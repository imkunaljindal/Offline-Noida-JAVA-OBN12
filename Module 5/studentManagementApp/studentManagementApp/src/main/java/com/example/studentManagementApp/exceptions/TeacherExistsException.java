package com.example.studentManagementApp.exceptions;

import com.example.studentManagementApp.repository.TeacherRepository;

public class TeacherExistsException extends RuntimeException {

    public TeacherExistsException(String message) {
        super(message);
    }
}
