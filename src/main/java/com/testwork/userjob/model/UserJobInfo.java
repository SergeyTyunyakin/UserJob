package com.testwork.userjob.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserJobInfo {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "id_company")
    private Long idCompany;
    @Column(name = "user_id")
    private Long userId;
    private String description;
    private Boolean isActivity;
    private LocalDateTime created;
    private LocalDateTime updated;
}
