package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class Pokemon {
    private final PokedexNumber pokedexNumber;
    private final CaptureRate captureRate;
    private final String name;

    // 부생성자 ---> Chaining
    public Pokemon(final int pokedexNumber, final int captureRate, final String name) {
        this(new PokedexNumber(pokedexNumber), new CaptureRate(captureRate), name);
    }

    // 주생성자
    private Pokemon(PokedexNumber pokedexNumber, CaptureRate captureRate, String name) {
        this.pokedexNumber = pokedexNumber;
        this.captureRate = captureRate;
        this.name = name;
    }


    // PokedexNumber로만 비교하면 된다
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(pokedexNumber, pokemon.pokedexNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokedexNumber);
    }
}
