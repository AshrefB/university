package com.ashref.university.services.jpa;

import com.ashref.university.entities.Student;
import com.ashref.university.repositories.StudentRepository;
import com.ashref.university.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Student With ID: "+id));
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public List<Student> getStudentsByDob(LocalDate date) {
        List<Student> students = new ArrayList<>();
        studentRepository.findAllByDob(date).orElse(students).forEach(students::add);
        return students;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        if(!studentRepository.existsById(student.getId()))
            throw new NoSuchElementException("No Student With ID:"+student.getId());

        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return student;
    }
}
