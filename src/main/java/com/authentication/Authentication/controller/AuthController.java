package com.authentication.Authentication.controller;

import com.authentication.Authentication.dto.AuthLogDto;
import com.authentication.Authentication.dto.AuthRequestDto;
import com.authentication.Authentication.dto.AuthenticationResponseDto;
import com.authentication.Authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/Auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("Login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthLogDto authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @PostMapping("Registrar")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody AuthRequestDto authRequestDto) {
        return ResponseEntity.ok(authService.register(authRequestDto));
    }

}
