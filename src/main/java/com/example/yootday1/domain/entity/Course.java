package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "courses")
@Setter
@Getter
public class Course extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String courseCode;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @Column(length = 500)
    private String description;

    @Column(name = "tuition_fee", columnDefinition = "decimal(12,2)")
    private double tuitionFee;

    private int totalSessions;
    private Boolean isActive = true;
}
