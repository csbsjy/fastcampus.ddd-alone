package io.github.wotjd243.pokemon.pokemon.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;
    private final CaptureService captureService;

    private final ApplicationEventPublisher publisher;

    public Pokemon find(final int number) {
        return getById(number);
    }

    @Transactional
    public void capture(final String userId, final int pokemonNumber) {
        Pokemon pokemon = pokemonRepository.findById(NationalPokedexNumber.valueOf(pokemonNumber));
        Trainer trainer = trainerRepository.findById(userId).orElse(new Trainer("aaa"));
        if (captureService.isCaught(pokemon, trainer)) {
            publisher.publishEvent(new CaughtPokemonEvent(userId, pokemonNumber)); // 포켓몬 잡혔다!
        }
    }

    private Pokemon getById(int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }

}
