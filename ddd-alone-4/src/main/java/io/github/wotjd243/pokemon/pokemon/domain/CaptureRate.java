package io.github.wotjd243.pokemon.pokemon.domain;

public class CaptureRate {
    private static final int MAX_RATE =255;
    private static final int MIN_RATE = 3;

    private final int rate;

    public CaptureRate(int rate) {
        validate(rate);
        this.rate = rate;
    }

    private void validate(int value) {
        if(value < MIN_RATE || value > MAX_RATE){
            throw new IllegalArgumentException("");
        }
    }
}
