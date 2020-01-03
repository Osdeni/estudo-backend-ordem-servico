package com.ojs.ordemservico;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojs.ordemservico.controllers.dto.evolucoes.FormEvolucaoDto;
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
public class EvolucaoTest extends AbstractTest {

    @Test
    public void acessoSemToken() throws Exception {
        mvc.perform(get("/ordem-servicos/4/evolucoes")).andExpect(status().isUnauthorized());
    }

    @Test
    public void listarEvolucoesOsId4() throws Exception {
        mvc.perform(auth(get("/ordem-servicos/4/evolucoes")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(3)));
    }

    @Test
    public void cadastrarErroValidacao() throws Exception {

        String token = mockToken(funcRoleTecnico);

        FormEvolucaoDto form = new FormEvolucaoDto();
        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/ordem-servicos/1/evolucoes"), token)
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[*]", hasSize(1)))
                .andExpect(jsonPath("$[0].campo").value("descricaoOuStatus"));
    }

    @Test
    public void cadastrarEvolucaoComRoleInvalido() throws Exception {

        String token = mockToken(funcRoleTecnico);

        FormEvolucaoDto form = new FormEvolucaoDto("Descricao teste");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/ordem-servicos/5/evolucoes"), token)
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());

    }

    @Test
    public void cadastrarEvolucaoSucesso() throws Exception {

        String token = mockToken(funcRoleTecnico2);

        FormEvolucaoDto form = new FormEvolucaoDto("Testes");

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/ordem-servicos/5/evolucoes"), token)
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber());
    }
}