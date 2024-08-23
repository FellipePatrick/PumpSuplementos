package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDTO;
import com.example.demo.service.TokenService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/token/")
public class AuthenticationController {

    private final TokenService service;
    private final AuthenticationManager authenticationManager;


    @PostMapping
    public String getToken(@RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager
        .authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password())
            );
        System.out.println("autenticação: " + authentication.isAuthenticated());
        return service.generateToken(authentication);
    }
}
