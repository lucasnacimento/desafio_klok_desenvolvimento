package com.desafio.klok.developer.api_a.application.service;

import com.desafio.klok.developer.api_a.infrastructure.configSecurity.auth.JwtUtils;
import com.desafio.klok.developer.api_a.infrastructure.configSecurity.service.UserSecurityService;
import com.desafio.klok.developer.api_a.presentation.dto.LoginDTO;
import com.desafio.klok.developer.api_a.presentation.dto.MensagemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSecurityService userService;

    @Autowired
    private JwtUtils jwtUtils;
    
    public MensagemDTO fazerLogin(LoginDTO login) throws Exception {
        String username = login.getUsername();
        String password = login.getPassword();

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new Exception("Erro na autenticação " + login.getUsername());
        }

        UserDetails loadedUser = userService.loadUserByUsername(username);

        String token = jwtUtils.generateToken(loadedUser);

        MensagemDTO responseDTO = new MensagemDTO(token, 200);
        return responseDTO;
        
    }
}
