package com.example.yootday1.dto.scheduleSlot;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScheduleSlotResponse {

    private Long id;

    private String slotCode;

    private Integer weekday;

    private LocalTime startTime;

    private LocalTime endTime;

    private String note;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
