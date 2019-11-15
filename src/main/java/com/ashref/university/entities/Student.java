package com.ashref.university.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cin;
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @ManyToOne
    private Class aClass;
}
