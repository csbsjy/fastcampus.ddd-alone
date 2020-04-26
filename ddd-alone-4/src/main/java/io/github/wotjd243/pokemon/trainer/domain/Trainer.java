package io.github.wotjd243.pokemon.trainer.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trainer {

    @Id
    private String id;

    @Embedded
    private Level level;

    @ElementCollection // 데이터가 수정되면 다 삭제하고 다시 삽입해야하는 단점이 있지만, 이 요구사항에서 6개를 넘지 않는 다는 것을 알고 있음
    private List<PokemonCaught> party; // Pokemon 이 아닌 새로운 Context의 새로운 도메인 모델을 도출

    public Trainer(String id) {
        this(id, Level.ONE, new ArrayList<>());
    }

    public Trainer(String id, Level level, List<PokemonCaught> party) {
        this.id = id;
        this.level = level;
        this.party = new ArrayList<>(party);
    }

    public void catchPokemon(final int number, final String name) {
        this.party.add(new PokemonCaught(number, name));
        levelUp();
    }

    private void levelUp() {
        this.level = level.up();
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level.toInt();
    }

    public List<PokemonCaught> getParty() {
        return new ArrayList<>(party);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
