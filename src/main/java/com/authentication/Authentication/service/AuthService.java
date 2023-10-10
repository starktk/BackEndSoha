package com.authentication.Authentication.service;

import com.authentication.Authentication.dto.AuthLogDto;
import com.authentication.Authentication.dto.AuthRequestDto;
import com.authentication.Authentication.dto.AuthenticationResponseDto;
import com.authentication.Authentication.model.Usuario;
import com.authentication.Authentication.model.enums.Role;
import com.authentication.Authentication.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponseDto login(AuthLogDto authLogDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authLogDto.getEmail(),
                        authLogDto.getPassword()
                )
        );
        var user = usuarioRepository.findByEmail(authLogDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.genetareToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDto register(AuthRequestDto authRequestDto) {
     var user = Usuario.builder()
             .email(authRequestDto.getEmail())
             .password(passwordEncoder.encode(authRequestDto.getPassword()))
             .role(Role.USER)
             .build();
     usuarioRepository.save(user);
     var jwtToken = jwtService.genetareToken(user);
     return AuthenticationResponseDto.builder()
             .token(jwtToken)
             .build();
    }
}
