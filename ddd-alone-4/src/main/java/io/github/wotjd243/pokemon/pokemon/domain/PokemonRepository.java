package io.github.wotjd243.pokemon.pokemon.domain;

// Domain에서 도출된 Repository 실제 구현체는 Infrastructure, DIP
public interface PokemonRepository {
    Pokemon findById(NationalPokedexNumber number); // Aggregate 단위로 조회해야 한다.
}
