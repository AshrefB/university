package com.ashref.university.services;

import com.ashref.university.entities.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByDob(LocalDate date);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    Student deleteStudent(Long id);
}
