package com.example.yootday1.service;

public interface EmailService {
    void sendAccountInfoEmail(String toEmail, String username, String password, String fullName);
}
