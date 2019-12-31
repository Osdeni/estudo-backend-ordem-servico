package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.config.security.TokenService;
import com.ojs.ordemservico.controllers.dto.autenticacao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autenticar")
public class AutenticacaoController {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<AutenticacaoDto> autenticar(@RequestBody @Valid LoginForm form) {

        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);

            String token = tokenService.gerarToken(authentication);

            UsuarioDto usuarioLogado = new UsuarioDto(tokenService.getUsuarioLogado());
            
            return ResponseEntity.ok(new TokenDto(token, "Bearer", usuarioLogado));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body(new ErroDto("Usuário ou senha inválidos"));
        }

    }
}
