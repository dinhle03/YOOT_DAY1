package com.example.yootday1.dto.courseClass;

import com.example.yootday1.domain.entity.Course;
import com.example.yootday1.domain.entity.Room;
import com.example.yootday1.domain.entity.ScheduleSlot;
import com.example.yootday1.domain.entity.Teacher;
import com.example.yootday1.domain.enums.ClassStatus;
import com.example.yootday1.dto.course.CourseResponse;
import com.example.yootday1.dto.room.RoomResponse;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotResponse;
import com.example.yootday1.dto.teacher.TeacherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseClassResponse {
    private Long id;
    private String classCode;
    private String name;
    private CourseResponse course;
    private RoomResponse room;
    private ScheduleSlotResponse scheduleSlot;
    private TeacherResponse mainTeacher;
    private TeacherResponse assistantTeacher;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxStudents;
    private float tuitionFee;
    private ClassStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
