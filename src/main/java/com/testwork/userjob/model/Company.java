package com.testwork.userjob.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean isActivity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_company")
    private List<UserJobInfo> userJobInfo=new ArrayList<>();
}
