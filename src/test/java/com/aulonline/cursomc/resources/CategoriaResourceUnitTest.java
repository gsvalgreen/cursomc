package com.aulonline.cursomc.resources;


import com.aulonline.cursomc.dominio.Categoria;
import com.aulonline.cursomc.services.CategoriaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoriaResource.class)
public class CategoriaResourceUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriaService categoriaService;

    @Test
    public void deveRetornarCategoriaUsandoId() throws Exception {
        int id = 1;
        Categoria categoria = new Categoria(id, "Informática");

        given(categoriaService.buscar(anyInt())).willReturn(categoria);

        mockMvc.perform(get("/categorias/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasKey("id")))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$", hasKey("nome")))
                .andExpect(jsonPath("$.nome", is("Informática")));
    }
}
