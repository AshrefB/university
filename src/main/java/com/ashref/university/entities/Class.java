package com.ashref.university.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Class implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxNum;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "aClass")
    private List<Student> students = new ArrayList<>();
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(
            name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers = new ArrayList<>();
}
