package com.example.yootday1.repository;

import com.example.yootday1.domain.entity.TuitionInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuitionInvoiceRepository extends JpaRepository<TuitionInvoice, Long> {
    List<TuitionInvoice> findByStudentId(Long studentId);

    List<TuitionInvoice> findByStudentParentId(Long parentId);

}
