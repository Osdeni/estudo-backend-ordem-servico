package com.ojs.ordemservico;

import com.ojs.ordemservico.config.exception.ResourceNotFoundException;
import com.ojs.ordemservico.config.security.TokenService;
import com.ojs.ordemservico.entities.Usuario;
import com.ojs.ordemservico.repository.UsuarioRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Optional;

public abstract class AbstractTest {
    protected String funcRoleAtendimento = "func1@gmail.com";
    protected String funcRoleTecnico = "func2@gmail.com";
    protected String funcRoleTecnico2 = "func3@gmail.com";

    @Autowired
    protected TokenService tokenService;

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @LocalServerPort
    protected int port;

    protected String token;

    @Autowired
    protected MockMvc mvc;

    protected MockHttpServletRequestBuilder auth(MockHttpServletRequestBuilder m) {
        return m.header("Authorization", "Bearer " + this.token);
    }

    protected MockHttpServletRequestBuilder auth(MockHttpServletRequestBuilder m, String token) {
        return m.header("Authorization", "Bearer " + token);
    }

    protected String mockToken(String email) throws ResourceNotFoundException {
        Optional<Usuario> usuarioFuncAtendimento = usuarioRepository.findByEmail(email);

        if (usuarioFuncAtendimento.isPresent()) {
            return this.tokenService.gerarToken(usuarioFuncAtendimento.get());
        }

        throw new ResourceNotFoundException("Usuário não encontrado");
    }

    @Before
    public void setupToken() throws ResourceNotFoundException {
        System.out.println("######## GERANDO TOKEN ######## ");
        this.token = this.mockToken(funcRoleAtendimento);
    }
}
