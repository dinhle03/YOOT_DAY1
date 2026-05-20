package com.example.yootday1.repository;

import com.example.yootday1.domain.entity.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
}
