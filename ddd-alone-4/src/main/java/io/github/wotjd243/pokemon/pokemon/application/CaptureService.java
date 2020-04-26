package io.github.wotjd243.pokemon.pokemon.application;

import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import org.springframework.stereotype.Component;

@Component
public class CaptureService {

    public boolean isCaught(Pokemon pokemon, Trainer trainer) {
        return pokemon.getCaptureRate() < (trainer.getLevel() + 100);
    }

}
