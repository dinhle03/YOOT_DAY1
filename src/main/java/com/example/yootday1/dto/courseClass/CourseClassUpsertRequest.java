package com.example.yootday1.dto.courseClass;


import com.example.yootday1.domain.enums.ClassStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CourseClassUpsertRequest {
    @NotBlank @Size(max = 20) String classCode;
    @NotBlank @Size(max = 100) String name;
    @NotNull Long courseId;
    @NotNull Long roomId;
    @NotNull Long scheduleSlotId;
    @NotNull Long mainTeacherId;
    Long assistantTeacherId;
    @NotNull LocalDate startDate;
    @NotNull LocalDate endDate;
    @NotNull @Min(1) Integer maxStudents;
    @NotNull float tuitionFee;
    @NotNull ClassStatus status;
}
