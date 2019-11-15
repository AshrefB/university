package com.ashref.university.services;

import com.ashref.university.entities.Teacher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface TeacherService {
    Teacher getTeacherById(Long id);
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Teacher deleteTeacher(Long id);
}
