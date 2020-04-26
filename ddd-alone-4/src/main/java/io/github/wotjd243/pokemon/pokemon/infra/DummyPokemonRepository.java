package io.github.wotjd243.pokemon.pokemon.infra;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;

//@Repository
public class DummyPokemonRepository implements PokemonRepository {
    @Override
    public Pokemon findById(NationalPokedexNumber number) {
        return DummyPokemonData.get(number);
    }
}
