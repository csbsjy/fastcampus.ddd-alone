package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PokedexNumberTest {

    @DisplayName("도감번호가 1미만 151초과면 익셉션을 던진다")
    @ValueSource(ints = {-1, 0, 152})
    @ParameterizedTest
    void exception(int pokedexNumber) {
        assertThatThrownBy(() -> new PokedexNumber(pokedexNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("도감번호는 %d이상 %d이하여야 합니다", 1, 151));
    }

    @DisplayName("같은 넘버를 가지면 같은 포켓넘버다")
    @Test
    void equlas() {
        PokedexNumber pokedexNumber = new PokedexNumber(1);
        PokedexNumber pokedexNumber1 = new PokedexNumber(1);

        assertThat(pokedexNumber).isEqualTo(pokedexNumber1);
    }

}