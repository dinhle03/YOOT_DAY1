package com.example.yootday1.dto.student;

import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.domain.enums.Gender;
import com.example.yootday1.domain.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;

    private String studentCode;

    private String fullName;

    private LocalDate dateOfBirth;

    private Gender gender = Gender.OTHER;

    private String gradeLevel;

    private String schoolName;

    private String phone;

    private String description;

    private Parent parent;

    private StudentStatus status = StudentStatus.ACTIVE;

    private BigDecimal latestScore = BigDecimal.ZERO;

    private String note;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
