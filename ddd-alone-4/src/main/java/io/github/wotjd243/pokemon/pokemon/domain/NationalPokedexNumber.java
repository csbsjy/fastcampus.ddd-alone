package io.github.wotjd243.pokemon.pokemon.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class NationalPokedexNumber {
    public static final int MIN_INDEX_NUMBER = 1;
    public static final int MAX_INDEX_NUMBER = 151;

    private static final Map<Integer, NationalPokedexNumber> cached = new HashMap<>();

    private final int number;

    public NationalPokedexNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static NationalPokedexNumber valueOf(final int number) {
        cached.putIfAbsent(number, new NationalPokedexNumber(number));
        return cached.get(number);
    }

    public int toInt() {
        return number;
    }

    private void validate(int pokedexNumber) {
        if (pokedexNumber < MIN_INDEX_NUMBER || pokedexNumber >= MAX_INDEX_NUMBER) {
            throw new IllegalArgumentException(String.format("도감번호는 %d이상 %d이하여야 합니다", MIN_INDEX_NUMBER, MAX_INDEX_NUMBER));
        }
    }

    // 동일성 보장은 못해도 동등성 보장은 해준다
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NationalPokedexNumber that = (NationalPokedexNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
