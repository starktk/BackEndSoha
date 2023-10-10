package com.authentication.Authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/Health")
public class HealthSecurity {

    @GetMapping
    public ResponseEntity<String> helloMyFriends() {
        return ResponseEntity.ok("Auth com sucess");
    }
}
