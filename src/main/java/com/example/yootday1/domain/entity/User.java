package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import com.example.yootday1.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User extends AuditableEntity {
    @Column(columnDefinition = "varchar(50)")
    private String username;
    @Column(columnDefinition = "varchar(255)")
    private String passwordHash;
    @Column(columnDefinition = "varchar(100)")
    private String fullName;
    @Column(columnDefinition = "varchar(20)")
    private String phone;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserRole role;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
