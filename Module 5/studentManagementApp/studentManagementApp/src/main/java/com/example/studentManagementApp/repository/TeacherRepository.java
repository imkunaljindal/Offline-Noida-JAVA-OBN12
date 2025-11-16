package com.example.studentManagementApp.repository;

import com.example.studentManagementApp.exceptions.TeacherExistsException;
import com.example.studentManagementApp.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Slf4j
public class TeacherRepository {

    HashMap<Integer, Teacher> teachersDb = new HashMap<>();

    public String addTeacher(Teacher teacher) {
        if(teachersDb.containsKey(teacher.getId())) {
            throw new TeacherExistsException("Id: "+ teacher.getId()+ " already exisits");
        }
        teachersDb.put(teacher.getId(),teacher);
        log.info("Teacher with id: "+teacher.getId()+ " added");
        return "Teacher added successfully";
    }
}
