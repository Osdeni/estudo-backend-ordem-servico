package com.ojs.ordemservico;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojs.ordemservico.controllers.dto.pessoas.FormPessoaDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PessoaTest extends AbstractTest {

    @Test
    public void acessoSemToken() throws Exception {
        mvc.perform(get("/pessoas")).andExpect(status().isUnauthorized());
    }

    @Test
    public void listarTodosFuncionarios() throws Exception {
        mvc.perform(auth(get("/pessoas/funcionarios")))
                .andExpect(status().isOk());
    }

    @Test
    public void listarTodasPessoas() throws Exception {
        mvc.perform(auth(get("/pessoas")))
                .andExpect(status().isOk());
    }

    @Test
    public void listarTodasPessoasComNome() throws Exception {
        mvc.perform(auth(get("/pessoas?nome=cli")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(3)));
    }

    @Test
    public void listarTodasPessoasComNomeInexistente() throws Exception {
        mvc.perform(auth(get("/pessoas?nome=cliclicli")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(0)));
    }


    @Test
    public void cadastrarClienteErroValidacao() throws Exception {

        FormPessoaDto form = new FormPessoaDto();
        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/pessoas"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void cadastrarClienteSucesso() throws Exception {
        FormPessoaDto form = new FormPessoaDto(
                "Joaquim da Silva", "joaquim@gmail.com",
                "Endereço x", "(48)99124-5987");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/pessoas"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    public void cadastrarClienteRoleInvalido() throws Exception {

        String token = this.mockToken(funcRoleTecnico);

        FormPessoaDto form = new FormPessoaDto(
                "Joaquim da Silva", "joaquim@gmail.com",
                "Endereço x", "(48)99124-5987");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/pessoas"), token)
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}