package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugRockPapersScissorsTest {

    @Test
    @DisplayName("Guanya Jugador1")
    void guanyaJugador1() {
        assertAll(
                ()->   assertEquals(1, DebugRockPapersScissors.guanya("paper", "pedra"),"Error quan el jugador1 juga paper i el jugador 2 juga pedra"),
                ()->   assertEquals(1, DebugRockPapersScissors.guanya("pedra", "tisores"),"Error quan el jugador1 juga pedra i el jugador 2 juga tisores"),
                ()->   assertEquals(1, DebugRockPapersScissors.guanya("tisores", "paper"),"Error quan el jugador1 juga tisores i el jugador 2 juga paper")
        );
    }

    @Test
    @DisplayName("Guanya Jugador2")
    void guanyaJugador2() {
        assertAll(
                ()->   assertEquals(2, DebugRockPapersScissors.guanya("pedra", "paper"),"Error quan el jugador2 juga paper i el jugador 1 juga pedra"),
                ()->   assertEquals(2, DebugRockPapersScissors.guanya("tisores", "pedra"),"Error quan el jugador2 juga pedra i el jugador 1 juga tisores"),
                ()->   assertEquals(2, DebugRockPapersScissors.guanya("paper", "tisores"),"Error quan el jugador2 juga tisores i el jugador 1 juga paper")
        );
    }


    @Test
    @DisplayName("Empats")
    void empat() {
        assertAll(
                () -> assertEquals(0, DebugRockPapersScissors.guanya("pedra", "pedra")),
                () -> assertEquals(0, DebugRockPapersScissors.guanya("paper", "paper")),
                () -> assertEquals(0, DebugRockPapersScissors.guanya("tisores", "tisores"))
        );

    }
}