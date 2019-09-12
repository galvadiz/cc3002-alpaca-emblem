package model.units;

import model.map.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SorcererTest extends AbstractTestUnit {

    private Sorcerer sorcerer;
    private Sorcerer sorcerer2;

    @Override
    @Test
    public void constructorTest() {
        assertEquals(600, getTestUnit().getCurrentHitPoints());
        assertEquals(2, getTestUnit().getMovement());
        assertEquals(new Location(0, 0), getTestUnit().getLocation());
        assertFalse(getTestUnit().getItems().isEmpty());
    }

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        this.setWeapons();
        sorcerer = new Sorcerer(600, 2, field.getCell(0, 0), anima, luz, oscuridad);
        sorcerer2 = new Sorcerer(600, 2, field.getCell(1, 1), anima2, luz2, oscuridad2);
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    /**
     * Checks if the bow is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipMagiaTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(anima);
        assertEquals(anima, sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void attackTest(){
        assertEquals(600, sorcerer.getCurrentHitPoints());
        sorcerer2.attack(sorcerer);
        assertEquals(600, sorcerer.getCurrentHitPoints());

        sorcerer2.equipItem(luz2);
        sorcerer2.attack(sorcerer);
        assertEquals(570, sorcerer.getCurrentHitPoints());

        sorcerer.equipItem(anima);
        sorcerer2.attack(sorcerer);
        assertEquals(560, sorcerer.getCurrentHitPoints());

        sorcerer2.equipItem(oscuridad2);
        assertEquals(oscuridad2, sorcerer2.getEquippedItem());

        sorcerer2.attack(sorcerer);
        assertEquals(515, sorcerer.getCurrentHitPoints());

        sorcerer2.equipItem(anima2);
        assertEquals(anima2, sorcerer2.getEquippedItem());
        sorcerer2.attack(sorcerer);
        assertEquals(485, sorcerer.getCurrentHitPoints());

    }
}