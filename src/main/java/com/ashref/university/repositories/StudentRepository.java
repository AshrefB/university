package com.ashref.university.repositories;

import com.ashref.university.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<List<Student>> findAllByDob(LocalDate date);
    Optional<Student> findByCin(int cin);
}
