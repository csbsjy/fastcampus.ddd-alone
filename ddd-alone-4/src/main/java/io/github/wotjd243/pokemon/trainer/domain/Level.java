package io.github.wotjd243.pokemon.trainer.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class Level {
    static final Level ONE = new Level(1);
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 30;
    private int level;

    public Level(int level) {
        validate(level);
        this.level = level;
    }

    private void validate(int level) {
        if (level < MIN_LEVEL || level > MAX_LEVEL) {
            throw new IllegalArgumentException(String.format("레벨은 %d이상, %d 이하", MIN_LEVEL, MAX_LEVEL));
        }
    }

    public int toInt() {
        return level;
    }

    public Level up() {
        if (isMaxLevel(level)) {
            return this;
        }
        return new Level(level + 1);
    }

    private boolean isMaxLevel(int level) {
        return level == MAX_LEVEL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level1 = (Level) o;
        return level == level1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
