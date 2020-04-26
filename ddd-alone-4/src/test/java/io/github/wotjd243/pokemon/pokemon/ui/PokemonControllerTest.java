package io.github.wotjd243.pokemon.pokemon.ui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PokemonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void find() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pokemons/{number}", 1))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.number").isNumber())
                .andDo(print());

    }

}