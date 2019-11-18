package com.ashref.university.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "CIN cannot be blank")
    @Size(min = 8, max = 8, message = "CIN should be 8 numbers")
    private String cin;
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 45, message = "Name cannot be longer than 45 character")
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "teachers")
    private List<Class> classes = new ArrayList<>();
}
