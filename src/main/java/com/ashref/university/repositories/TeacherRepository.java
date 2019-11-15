package com.ashref.university.repositories;

import com.ashref.university.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
