package com.example.yootday1.repository;

import com.example.yootday1.domain.entity.LearningResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningResultRepository extends JpaRepository<LearningResult, Long> {

    boolean existsByStudentIdAndCourseClassIdAndResultMonth(Long studentId, Long courseClassId,
                                                            java.time.LocalDate resultMonth);
    List<LearningResult> findByStudentId(Long studentId);

}
