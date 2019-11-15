package com.ashref.university.services.jpa;

import com.ashref.university.entities.Class;
import com.ashref.university.repositories.ClassRepository;
import com.ashref.university.services.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    @Override
    public Class getClassById(Long id) {
        return classRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Class With ID: "+id));
    }

    @Override
    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        classRepository.findAll().forEach(classes::add);
        return classes;
    }

    @Override
    public Class addClass(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public Class updateClass(Class aClass) {
        if(!classRepository.existsById(aClass.getId()))
            throw new NoSuchElementException("No Class With ID:"+aClass.getId());

        return classRepository.save(aClass);
    }

    @Override
    public Class deleteClass(Long id) {
        Class aClass = getClassById(id);
        classRepository.delete(aClass);
        return aClass;
    }
}
