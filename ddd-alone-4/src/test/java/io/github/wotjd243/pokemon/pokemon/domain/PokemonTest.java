package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PokemonTest {

    @DisplayName("이름과 도감번호, 포획률을 가진 포켓몬을 생성한다")
    @Test
    void create(){
        new Pokemon(1, 5,  "이상해씨");
    }

}