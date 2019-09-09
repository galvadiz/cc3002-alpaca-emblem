package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SorcererTest extends AbstractTestUnit {

    private Sorcerer sorcerer;
    private Sorcerer sorcerer2;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        this.setWeapons();
        sorcerer = new Sorcerer(100, 2, field.getCell(0, 0), magia, magia3);
        sorcerer2 = new Sorcerer(100, 2, field.getCell(1, 1), magia2, magia3);
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
        sorcerer.equipItem(magia);
        assertEquals(magia, sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void attackTest(){
        assertEquals(100, sorcerer.getCurrentHitPoints());
        sorcerer.equipItem(magia);
        sorcerer2.equipItem(magia2);
        sorcerer.attack(sorcerer2);
        assertEquals(55, sorcerer2.getCurrentHitPoints());
        sorcerer.equipItem(magia3);
        assertEquals(magia3, sorcerer.getEquippedItem());
        sorcerer.attack(sorcerer2);
        assertEquals(45, sorcerer2.getCurrentHitPoints());
    }
}