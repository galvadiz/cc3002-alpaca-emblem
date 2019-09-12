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

    private Sorcerer sorcerer, sorcerer2;

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
    public void equipAnimaTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(anima);
        assertEquals(anima, sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipLuzTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(luz);
        assertEquals(luz, sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipOscuridadTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(oscuridad);
        assertEquals(oscuridad, sorcerer.getEquippedItem());
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
        assertEquals(600, sorcerer2.getCurrentHitPoints());

        sorcerer.equipItem(anima);
        sorcerer2.attack(sorcerer);
        assertEquals(560, sorcerer.getCurrentHitPoints());
        assertEquals(555, sorcerer2.getCurrentHitPoints());

        sorcerer2.equipItem(oscuridad2);
        assertEquals(oscuridad2, sorcerer2.getEquippedItem());

        sorcerer2.attack(sorcerer);
        assertEquals(515, sorcerer.getCurrentHitPoints());
        assertEquals(545, sorcerer2.getCurrentHitPoints());

        sorcerer2.equipItem(anima2);
        assertEquals(anima2, sorcerer2.getEquippedItem());
        sorcerer2.attack(sorcerer);
        assertEquals(485, sorcerer.getCurrentHitPoints());
        assertEquals(515, sorcerer2.getCurrentHitPoints());


        sorcerer.equipItem(luz);
        assertEquals(luz, sorcerer.getEquippedItem());

        sorcerer2.equipItem(luz2);
        sorcerer2.attack(sorcerer);
        assertEquals(455, sorcerer.getCurrentHitPoints());
        assertEquals(485, sorcerer2.getCurrentHitPoints());


        sorcerer2.equipItem(oscuridad2);
        assertEquals(oscuridad2, sorcerer2.getEquippedItem());

        sorcerer2.attack(sorcerer);
        assertEquals(445, sorcerer.getCurrentHitPoints());
        assertEquals(440, sorcerer2.getCurrentHitPoints());

        sorcerer2.equipItem(anima2);
        assertEquals(anima2, sorcerer2.getEquippedItem());
        sorcerer2.attack(sorcerer);
        assertEquals(400, sorcerer.getCurrentHitPoints());
        assertEquals(430, sorcerer2.getCurrentHitPoints());


        sorcerer.equipItem(oscuridad);
        assertEquals(oscuridad, sorcerer.getEquippedItem());

        sorcerer2.equipItem(luz2);
        sorcerer2.attack(sorcerer);
        assertEquals(355, sorcerer.getCurrentHitPoints());
        assertEquals(420, sorcerer2.getCurrentHitPoints());


        sorcerer2.equipItem(oscuridad2);
        assertEquals(oscuridad2, sorcerer2.getEquippedItem());

        sorcerer2.attack(sorcerer);
        assertEquals(325, sorcerer.getCurrentHitPoints());
        assertEquals(390, sorcerer2.getCurrentHitPoints());

        sorcerer2.equipItem(anima2);
        assertEquals(anima2, sorcerer2.getEquippedItem());
        sorcerer2.attack(sorcerer);
        assertEquals(315, sorcerer.getCurrentHitPoints());
        assertEquals(345, sorcerer2.getCurrentHitPoints());



    }
}