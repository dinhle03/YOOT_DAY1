package com.example.yootday1.repository;

import com.example.yootday1.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByInvoiceId(Long invoiceId);

//    @Query("SELECT o FROM Payment o WHERE o.invoice.id=:invoiceId")
//    List<Payment> findByInvoice(@Param("invoiceId") Long invoiceId);
}
