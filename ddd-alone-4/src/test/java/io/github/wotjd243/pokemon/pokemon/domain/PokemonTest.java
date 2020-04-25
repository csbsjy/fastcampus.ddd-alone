package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @DisplayName("이름과 도감번호, 포획률을 가진 포켓몬을 생성한다")
    @Test
    void create(){
        new Pokemon(1, 5,  "이상해씨");
    }

    // TODO: 여기서는 VO 에 대한 테스트를 할 필요가 없어진다.
    // 테스트코드도 중복을 제거해야 한다 !!
    @DisplayName("도감번호는 1미만, 152 이상, 포획률은 3이상 255이하만 가진다")
    @CsvSource({"1,2", " -1. "})
    @ParameterizedTest
    void pokedexNumberException(int pokedexNumber){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Pokemon(pokedexNumber, 5, "치코리타"));
    }

}