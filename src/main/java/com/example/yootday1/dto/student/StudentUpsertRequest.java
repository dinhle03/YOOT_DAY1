package com.example.yootday1.dto.student;

import com.example.yootday1.domain.enums.Gender;
import com.example.yootday1.domain.enums.StudentStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpsertRequest {
    @Size(min = 2, max = 10)
    private String studentCode;
    @Size(min = 2)
    private String fullName;

    private LocalDate dateOfBirth;
    @NotNull
    private Gender gender = Gender.OTHER;
    @NotBlank
    private String gradeLevel;

    private String schoolName;
    @NotBlank
    @Pattern(regexp = "^(84|0[35789])+([0-9]{8})$")
    private String phone;

    private String description;
    @Min(1)
    private Long parentId;

    private StudentStatus status = StudentStatus.ACTIVE;
    @Min(value = 0)
    @Max(value = 10)
    private BigDecimal latestScore = BigDecimal.ZERO;

    private String note;

}
