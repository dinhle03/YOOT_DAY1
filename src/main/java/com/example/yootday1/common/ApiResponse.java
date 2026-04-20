package com.example.yootday1.common;

import java.time.LocalDateTime;

public record ApiResponse<T>(boolean success, String messge, T data, LocalDateTime timestamp) {

    public static <T> ApiResponse<T> success(String messge, T data){
        return new ApiResponse<>(true, messge, data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> success(T data){
        return success("Success", data);
    }

    public static ApiResponse<Void> successMessage(String messge){
        return success(messge, null);
    }

    public static  ApiResponse<Void> error(String messge){
        return new ApiResponse<>(false, messge, null, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(String messge, T data){
        return new ApiResponse<>(false, messge, data, LocalDateTime.now());
    }

}
