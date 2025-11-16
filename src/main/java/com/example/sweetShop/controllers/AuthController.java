package com.example.sweetShop.controllers;

import com.example.sweetShop.dto.AuthRequest;
import com.example.sweetShop.dto.AuthResponse;
import com.example.sweetShop.dto.RegisterRequest;
import com.example.sweetShop.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        service.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req) {
        AuthResponse resp = service.login(req);
        return ResponseEntity.ok(resp);
    }
}

