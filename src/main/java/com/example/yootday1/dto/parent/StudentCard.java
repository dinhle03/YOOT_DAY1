package com.example.yootday1.dto.parent;

import com.example.yootday1.domain.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCard {
    private Long id;
    private String studentCode;
    private String fullName;
    private StudentStatus status;
    private BigDecimal latestScore;
}
