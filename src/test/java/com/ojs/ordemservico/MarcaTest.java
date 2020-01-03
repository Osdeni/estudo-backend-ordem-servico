package com.ojs.ordemservico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MarcaTest extends AbstractTest {

    @Test
    public void acessoSemToken() throws Exception {
        mvc.perform(get("/marcas")).andExpect(status().isUnauthorized());
    }

    @Test
    public void listarTodasMarcas() throws Exception {
        mvc.perform(auth(get("/marcas")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(6)));
    }
}