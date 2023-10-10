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

/**@Author Raul Rodrigues
 * Classe de serviço com regras de autenticação e filtros para gerar e extrair token jwt
 * @Version V2.0
 * @Returns Dto Body with Jwt Token**/
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**Método para autenticar login
     * @Params Email and Password
     * @Return Dto com Jwt Token **/
    public AuthenticationResponseDto login(AuthLogDto authLogDto) {
        if (verifyEmail(authLogDto.getEmail())) return null;
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

    /** Metodo para verificar formato especifico do email
     * @Return boolean**/
    public Boolean verifyEmail(String email) {
        if (!email.contains("@") && !email.contains(".com")) {
            return false;
        }
        return true;
    }
    /** Metodo para registrar usuario no banco com senha encriptada
     * @Params Email and PasswordEncrypted
     * @Return Dto Jwt Token**/
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
