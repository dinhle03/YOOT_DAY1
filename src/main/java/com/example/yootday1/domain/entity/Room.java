package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "rooms")
public class Room extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String roomCode;
    @Column(columnDefinition = "varchar(100)")
    private String name;

    private int capacity;
    @Column(columnDefinition = "varchar(255)")
    private String description;
}
