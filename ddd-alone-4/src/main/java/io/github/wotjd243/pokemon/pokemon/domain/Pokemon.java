package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class Pokemon {
    private final NationalPokedexNumber nationalPokedexNumber;
    private final CaptureRate captureRate;
    private final String name;

    // 부생성자 ---> Chaining
    public Pokemon(final int pokedexNumber, final int captureRate, final String name) {
        this(NationalPokedexNumber.valueOf(pokedexNumber), CaptureRate.valueOf(captureRate), name);
    }

    // 주생성자
    private Pokemon(NationalPokedexNumber nationalPokedexNumber, CaptureRate captureRate, String name) {
        this.nationalPokedexNumber = nationalPokedexNumber;
        this.captureRate = captureRate;
        this.name = name;
    }

    public NationalPokedexNumber getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public int getCaptureRate() {
        return captureRate.getRate();
    }

    public String getName() {
        return name;
    }

    // PokedexNumber로만 비교하면 된다
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(nationalPokedexNumber, pokemon.nationalPokedexNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalPokedexNumber);
    }
}
