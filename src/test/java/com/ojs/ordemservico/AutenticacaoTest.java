package com.ojs.ordemservico;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojs.ordemservico.controllers.dto.autenticacao.LoginForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AutenticacaoTest extends AbstractTest {

    @Test
    public void acessoComEmailESenhaEnexistentes() throws Exception {
        LoginForm form = new LoginForm("teste@gmail.com", "teste");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/autenticar"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.erro").value("Usuário ou senha inválidos"));
    }

    @Test
    public void acessoComEmailOkSenhaInexistentes() throws Exception {
        LoginForm form = new LoginForm(funcRoleAtendimento, "teste");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/autenticar"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.erro").value("Usuário ou senha inválidos"));
    }

    @Test
    public void acessoOk() throws Exception {
        LoginForm form = new LoginForm(funcRoleAtendimento, "secret");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/autenticar"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").isString())
                .andExpect(jsonPath("$.usuario.id").isNumber())
                .andExpect(jsonPath("$.usuario.nome").isString())
                .andExpect(jsonPath("$.usuario.roles").isArray());
    }
}