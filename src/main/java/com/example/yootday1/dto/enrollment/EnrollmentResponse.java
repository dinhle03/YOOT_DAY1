package com.example.yootday1.dto.enrollment;

import com.example.yootday1.domain.entity.CourseClass;
import com.example.yootday1.domain.entity.Student;
import com.example.yootday1.domain.enums.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EnrollmentResponse {
    private Long id;

    private Long studentId;

    private String studentName;

    private Long courseClassId;

    private String className;

    private LocalDate enrolledAt;

    private String status;

    private String note;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
