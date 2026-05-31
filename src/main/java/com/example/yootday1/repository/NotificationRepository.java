package com.example.yootday1.repository;

import com.example.yootday1.domain.entity.Notification;
import com.example.yootday1.domain.enums.NotificationRecipientType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientTypeAndRecipientRefIdOrderByCreatedAtDesc(NotificationRecipientType recipientType, Long recipientRefId);

}
