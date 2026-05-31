package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import com.example.yootday1.domain.enums.TeacherRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Setter
@Getter
public class Teacher extends AuditableEntity {
    @Column(name = "teacher_code", nullable = false, unique = true, length = 20)
    private String teacherCode;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "teacher_role", nullable = false, length = 20)
    private TeacherRole teacherRole;

    @Column(name = "cccd_image_url", length = 255)
    private String cccdImageUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
