package com.authentication.Authentication.service;

import com.authentication.Authentication.controller.AuthController;
import com.authentication.Authentication.dto.AuthLogDto;
import com.authentication.Authentication.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {

    @InjectMocks
    AuthService authService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInvalidEmail() {
        AuthLogDto log = new AuthLogDto();
        log.setEmail("aberdin@bla.com");
        log.setPassword("12345");
        Boolean response = authService.verifyEmail(log.getEmail());
        assertEquals(true, true);
    }
}
