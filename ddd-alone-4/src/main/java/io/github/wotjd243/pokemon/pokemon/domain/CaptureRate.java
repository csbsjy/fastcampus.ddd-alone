package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class CaptureRate {
    private static final int MAX_RATE = 255;
    private static final int MIN_RATE = 3;

    private final int rate;

    public CaptureRate(int rate) {
        validate(rate);
        this.rate = rate;
    }

    private void validate(int value) {
        if (value < MIN_RATE || value > MAX_RATE) {
            throw new IllegalArgumentException(String.format("포획률은 %d이상 %d이하여야 합니다.", MIN_RATE, MAX_RATE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaptureRate that = (CaptureRate) o;
        return rate == that.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }
}
