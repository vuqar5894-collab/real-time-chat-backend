package com.vugar.chat_app.service;

import com.vugar.chat_app.dto.LoginRequest;
import com.vugar.chat_app.dto.auth.AuthResponse;
import com.vugar.chat_app.entity.User;
import com.vugar.chat_app.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse login(LoginRequest request){

        User user = userService.findByUsername(request.getUsername());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new AuthResponse(token);
    }

}