package com.ashref.university.services;

import com.ashref.university.entities.Class;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClassService {
    Class getClassById(Long id);
    List<Class> getAllClasses();
    Class addClass(Class aClass);
    Class updateClass(Class aClass);
    Class deleteClass(Long id);
}
