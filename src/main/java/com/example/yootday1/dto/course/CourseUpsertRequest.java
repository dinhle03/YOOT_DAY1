package com.example.yootday1.dto.course;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpsertRequest {
    @NotBlank
    @Size(max = 20)
    private String courseCode;
    @NotBlank
    @Size(max = 100)
    private String name;
    @Size(max = 500)
    private String description;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal tuitionFee = BigDecimal.ZERO;
    @NotNull
    @Min(1)
    private Integer totalSessions = 24;
    @NotNull
    private Boolean isActive = true;
}
