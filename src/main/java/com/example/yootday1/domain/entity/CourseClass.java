package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import com.example.yootday1.domain.enums.ClassStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "course_classes")
@Setter
@Getter
public class CourseClass extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String classCode;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "schedule_slot_id", nullable = false)
    private ScheduleSlot scheduleSlot;
    @ManyToOne
    @JoinColumn(name = "main_teacher_id", nullable = false)
    private Teacher mainTeacher;
    @ManyToOne
    @JoinColumn(name = "assistant_teacher_id", nullable = true)
    private Teacher assistantTeacher;

    private LocalDate startDate;

    private LocalDate endDate;

    private int maxStudents;
    private float tuitionFee;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ClassStatus status = ClassStatus.OPEN;
}
