package com.ashref.university.controllers;

import com.ashref.university.entities.Class;
import com.ashref.university.services.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping({"", "/"})
    @ResponseStatus(code = HttpStatus.FOUND)
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Class getClassById(@PathVariable long id) {
        return classService.getClassById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Class addClass(@RequestBody Class aClass) {
        return classService.addClass(aClass);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public Class updateClass(@RequestBody Class aClass) {
        return classService.updateClass(aClass);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Class deleteClass(@PathVariable long id) {
        return classService.deleteClass(id);
    }

}
