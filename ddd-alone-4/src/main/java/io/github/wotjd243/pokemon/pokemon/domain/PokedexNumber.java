package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class PokedexNumber {
    public static final int MAX_INDEX_NUMBER = 151;
    public static final int MIN_INDEX_NUMBER = 1;

    private final int number;

    public PokedexNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int pokedexNumber) {
        if(pokedexNumber < MIN_INDEX_NUMBER || pokedexNumber >= MAX_INDEX_NUMBER){
            throw new IllegalArgumentException();
        }
    }

    // 동일성 보장은 못해도 동등성 보장은 해준다
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokedexNumber that = (PokedexNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
