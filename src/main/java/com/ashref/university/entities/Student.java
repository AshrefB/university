package com.ashref.university.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotBlank(message = "CIN cannot be blank")
    @Size(min = 8, max = 8, message = "CIN should be 8 numbers")
    private String cin;
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 45, message = "Name cannot be longer than 45 character")
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Date of birth should be in the past")
    private LocalDate dob;
    @ManyToOne
    private Class aClass;
}
