package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class endTurnObserverTest {
    private GameController controller;

    @BeforeEach
    public void setUp(){
        controller = new GameController(3, 3);
        controller.initGame(3);
    }
    @Test
    public void endTurnTest(){
        assertEquals(controller.getTacticians().size(), controller.getOrdenTurnos().size());
        assertEquals(0, controller.getJugadoresQueHanTerminadoTurno());
        controller.getTurnOwner().endTurn();
        assertEquals(1, controller.getJugadoresQueHanTerminadoTurno());

    }

}
