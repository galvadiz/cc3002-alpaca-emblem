package controller;

import factory.items.FactoryItems;
import factory.units.FactoryUnits;
import model.items.Spear;
import model.items.Sword;
import model.units.Hero;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class deadHeroObserverTest {
    private GameController controller;
    private Spear spear;

    @BeforeEach
    public void setUp(){
        controller = new GameController(2, 3);
        FactoryItems f = new FactoryItems();
        spear = f.createSpear();
        spear.setPower(100);
        controller.initGame(3);
    }
    @Test
    public void deadHeroTest(){
        assertTrue(controller.getEstadoDelJuego());

        IUnit h1 = controller.getTurnOwner().getUnits().get(0);
        IUnit h2 = controller.getOrdenTurnos().get(1).getUnits().get(0);

        h1.setLocation(controller.getGameMap().getCell(0, 0));
        h2.setLocation(controller.getGameMap().getCell(0, 1));

        h1.addItem(spear);
        assertTrue(h1.getItems().contains(spear));
        h1.equipItem(spear);
        assertEquals(spear, h1.getEquippedItem());
        assertEquals(2, controller.getTacticians().size());

        h1.attack(h2);

        assertEquals(1, controller.getTacticians().size());
        controller.getTurnOwner().endTurn();
        assertFalse(controller.getEstadoDelJuego());

        /*assertEquals(controller.getTacticians().size(), controller.getOrdenTurnos().size());
        assertEquals(0, controller.getJugadoresQueHanTerminadoTurno());
        controller.getTurnOwner().endTurn();
        assertEquals(1, controller.getJugadoresQueHanTerminadoTurno());*/

    }

}
