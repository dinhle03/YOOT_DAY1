package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Setter
@Getter
@Table(name = "schedule_slots")
public class ScheduleSlot extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String slotCode;

    private byte weekday;

    private LocalTime startTime;
    private LocalTime endTime;

    @Column(columnDefinition = "varchar(255)")
    private String note;
}

