package com.example.yootday1.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {

    private Long id;

    private String roomCode;

    private String name;

    private int capacity;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
