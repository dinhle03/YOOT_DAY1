package com.example.yootday1.service.impl;

import com.example.yootday1.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Async
    @Override
    public void sendAccountInfoEmail(String toEmail, String username, String password, String fullName) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Thông tin tài khoản hệ thống YOEDU");
            
            String text = String.format(
                "Xin chào %s,\n\n" +
                "Tài khoản của bạn đã được tạo thành công trên hệ thống YOEDU.\n\n" +
                "Dưới đây là thông tin đăng nhập của bạn:\n" +
                "- Tên đăng nhập: %s\n" +
                "- Mật khẩu: %s\n\n" +
                "Vui lòng đăng nhập và đổi mật khẩu để bảo mật tài khoản.\n\n" +
                "Trân trọng,\n" +
                "Đội ngũ YOEDU",
                fullName, username, password
            );
            
            message.setText(text);
            javaMailSender.send(message);
            log.info("Email sent successfully to {}", toEmail);
        } catch (Exception e) {
            log.error("Failed to send email to {}", toEmail, e);
        }
    }
}
