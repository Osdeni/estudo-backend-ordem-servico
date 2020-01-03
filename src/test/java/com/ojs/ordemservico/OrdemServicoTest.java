package com.ojs.ordemservico;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojs.ordemservico.controllers.dto.ordemServicos.FormOrdemServicoDto;
import com.ojs.ordemservico.controllers.dto.ordemServicos.PessoaDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrdemServicoTest extends AbstractTest {

    @Test
    public void acessoSemToken() throws Exception {
        mvc.perform(get("/ordem-servicos")).andExpect(status().isUnauthorized());
    }

    @Test
    public void listarTodasOrdens() throws Exception {
        mvc.perform(auth(get("/ordem-servicos")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(6)))
                .andExpect(jsonPath("$.content[0].id").isNumber())
                .andExpect(jsonPath("$.content[0].tipo.id").isNumber())
                .andExpect(jsonPath("$.content[0].marca.id").isNumber())
                .andExpect(jsonPath("$.content[0].cliente.id").isNumber())
                .andExpect(jsonPath("$.content[0].responsavel.id").isNumber())
                .andExpect(jsonPath("$.content[0].status.label").isString())
                .andExpect(jsonPath("$.content[0].status.cssClass").isString())
                .andExpect(jsonPath("$.content[0].status.index").isString())
                .andExpect(jsonPath("$.content[0].status.index").isString())
                .andExpect(jsonPath("$.pageable.sort").isNotEmpty())
                .andExpect(jsonPath("$.pageable.pageNumber").isNumber())
                .andExpect(jsonPath("$.pageable.pageSize").isNumber());
    }

    @Test
    public void listarOrdensComStatusAberto() throws Exception {
        // cadastro antes no teste
        mvc.perform(auth(get("/ordem-servicos/?status=ABERTO")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(3)));
    }

    @Test
    public void listarOrdensComResposavel3() throws Exception {
        mvc.perform(auth(get("/ordem-servicos/?responsavel.id=3")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(3)));
    }

    @Test
    public void listarOrdensComResposavel2EAndamento() throws Exception {
        mvc.perform(auth(get("/ordem-servicos/?responsavel.id=2&status=ANDAMENTO")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)));
    }

    @Test
    public void verDetalhesExistente() throws Exception {
        mvc.perform(auth(get("/ordem-servicos/1")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.tipo.id").isNumber())
                .andExpect(jsonPath("$.marca.id").isNumber())
                .andExpect(jsonPath("$.cliente.id").isNumber())
                .andExpect(jsonPath("$.responsavel.id").isNumber())
                .andExpect(jsonPath("$.status.label").isString())
                .andExpect(jsonPath("$.status.cssClass").isString())
                .andExpect(jsonPath("$.status.index").isString())
                .andExpect(jsonPath("$.status.index").isString());
    }

    @Test
    public void verDetalhesInexistente() throws Exception {
        mvc.perform(auth(get("/ordem-servicos/30")))
                .andExpect(status().isNotFound());
    }


    @Test
    public void cadastrarErroValidacao() throws Exception {

        FormOrdemServicoDto form = new FormOrdemServicoDto();
        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/ordem-servicos"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[*]", hasSize(6)));
    }

    @Test
    public void cadastrarComSucesso() throws Exception {
        FormOrdemServicoDto form = new FormOrdemServicoDto(
                new Date(), "Defeito teste", 1, 1,
                new PessoaDto(5), 2
        );

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/ordem-servicos"))
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.status.index").value("ABERTO"));
    }

    @Test
    public void cadastrarOrdemComRoleInvalido() throws Exception {

        String token = this.mockToken(funcRoleTecnico);

        FormOrdemServicoDto form = new FormOrdemServicoDto(
                new Date(), "Defeito teste", 1, 1,
                new PessoaDto(5), 2
        );

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        mvc.perform(auth(post("/ordem-servicos"), token)
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}