package com.example.yootday1.service;

import com.example.yootday1.common.exception.BadRequestException;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.billing.InvoiceCreateRequest;
import com.example.yootday1.dto.billing.InvoiceResponse;
import com.example.yootday1.dto.payment.PaymentCreateRequest;
import com.example.yootday1.dto.payment.PaymentResponse;

import java.util.List;

public interface BillingService {
    InvoiceResponse createInvoice(InvoiceCreateRequest request) throws NotFoundException;
    List<InvoiceResponse> findInvoicesByStudent(Long studentId, String username) throws BadRequestException, NotFoundException;
    PaymentResponse createPayment(PaymentCreateRequest request, String username) throws NotFoundException, BadRequestException;
}
