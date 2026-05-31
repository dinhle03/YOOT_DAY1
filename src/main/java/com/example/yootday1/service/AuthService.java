package com.example.yootday1.service;

import com.example.yootday1.domain.entity.User;
import com.example.yootday1.dto.auth.*;

public interface AuthService {
    void register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(RefreshTokenRequest request);
    void changePassword(String username, ChangePasswordRequest request);
    CurrentUserResponse me(String username);
    User findActiveUserByUsername(String username);
}
