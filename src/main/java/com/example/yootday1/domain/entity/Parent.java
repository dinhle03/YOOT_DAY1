package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import com.example.yootday1.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "parents")
public class Parent extends AuditableEntity {

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String relationship;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender = Gender.OTHER;
}
