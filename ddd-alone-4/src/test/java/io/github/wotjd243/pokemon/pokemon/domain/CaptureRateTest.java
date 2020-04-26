package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CaptureRateTest {

    @DisplayName("3미만, 255초과인 포확률을 가지면 익셉션을 던진다")
    @ValueSource(ints = {-1, 2, 256})
    @ParameterizedTest
    void capturerate(int captureRate) {
        assertThatThrownBy(() -> new CaptureRate(captureRate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("포획률은 %d이상 %d이하여야 합니다.", 3, 255));
    }

}