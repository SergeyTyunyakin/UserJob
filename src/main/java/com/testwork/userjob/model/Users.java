package com.testwork.userjob.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String familyName;
    private String middleName;
    private String firstName;
    private LocalDate birthdate;
    private Integer age;
    private String description;
    private Boolean isBlocked;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<UserJobInfo> userJobInfo=new ArrayList<>();
}
