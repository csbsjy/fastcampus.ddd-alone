package io.github.wotjd243.pokemon.pokemon.domain;

import java.time.LocalDateTime;

public class CaughtPokemonEvent {
    private String userId;
    private int number;
    private LocalDateTime localDateTime;

    public CaughtPokemonEvent(String userId, int number) {
        this.userId = userId;
        this.number = number;
        this.localDateTime = LocalDateTime.now();
    }

    public int getNumber() {
        return number;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
