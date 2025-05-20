package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import application.dto.AuthRequest;
import application.dto.AuthResponse;
import application.model.Usuario;
import application.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public AuthResponse login(@RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken tk = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
        authManager.authenticate(tk);
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(request.getEmail());
        String token = tokenService.generateToken(usuario);
        return new AuthResponse(token);
    }
}