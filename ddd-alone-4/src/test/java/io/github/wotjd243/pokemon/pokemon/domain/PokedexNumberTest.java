package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PokedexNumberTest {

    @DisplayName("같은 넘버를 가지면 같은 포켓넘버다")
    @Test
    void equls(){
        PokedexNumber pokedexNumber = new PokedexNumber(1);
        PokedexNumber pokedexNumber1 = new PokedexNumber(1);

        assertThat(pokedexNumber).isEqualTo(pokedexNumber1);
    }

}