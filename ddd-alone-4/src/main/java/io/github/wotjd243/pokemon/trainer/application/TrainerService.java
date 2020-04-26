package io.github.wotjd243.pokemon.trainer.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;

    @Transactional
    public Trainer join(final String id) {
        return trainerRepository.save(new Trainer(id));
    }

    // 응용서비스가 이벤트를 핸들링한다
    // PokemonService에서 trainer에 add하는 부분을 없애버림
    @EventListener
    public void addPokemon(final CaughtPokemonEvent pokemonEvent) {
        Trainer trainer = trainerRepository.findById(pokemonEvent.getUserId()).get();
        trainer.catchPokemon(pokemonEvent.getNumber(), "안뇽");
    }
}
