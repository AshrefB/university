package com.ashref.university.services.jpa;

import com.ashref.university.entities.Teacher;
import com.ashref.university.repositories.TeacherRepository;
import com.ashref.university.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Teacher With ID: "+id));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if(!teacherRepository.existsById(teacher.getId()))
            throw new NoSuchElementException("No Teacher With ID:"+teacher.getId());

        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher deleteTeacher(Long id) {
        Teacher teacher = getTeacherById(id);
        teacherRepository.delete(teacher);
        return teacher;
    }
}
