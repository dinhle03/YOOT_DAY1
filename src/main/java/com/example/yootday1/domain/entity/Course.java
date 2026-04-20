package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class Course extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String courseCode;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "varchar(20)")
    private double tuitionFee;

    private int totalSessions;

    private byte isActive;
}
