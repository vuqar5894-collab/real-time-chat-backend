package com.vugar.chat_app.controller;

import com.vugar.chat_app.dto.LoginRequest;
import com.vugar.chat_app.dto.RegisterRequest;
import com.vugar.chat_app.dto.auth.AuthResponse;
import com.vugar.chat_app.entity.User;
import com.vugar.chat_app.service.AuthService;
import com.vugar.chat_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){

        return userService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );

    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

}
