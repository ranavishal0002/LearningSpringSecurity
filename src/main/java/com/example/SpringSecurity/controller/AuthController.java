package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.dto.LoginDto;
import com.example.SpringSecurity.dto.LoginResponseDto;
import com.example.SpringSecurity.dto.SignUpDto;
import com.example.SpringSecurity.dto.UserDto;
import com.example.SpringSecurity.service.AuthService;
import com.example.SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto) {
        UserDto userDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        LoginResponseDto loginResponse = authService.login(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}






