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

    private Sorcerer sorcerer, sorcerer2, sorcerer3;
    private Archer archer;
    private Fighter fighter;
    private Hero hero;
    private SwordMaster swordMaster;
    private Alpaca alpaca;
    private Cleric cleric;

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
        sorcerer3 = new Sorcerer(600, 2, field.getCell(0, 0), anima, luz, oscuridad);
        archer = new Archer(150, 2, field.getCell(1, 1), bow);
        swordMaster = new SwordMaster(150, 2, field.getCell(1, 1), spear, sword, axe);
        hero = new Hero(150, 2, field.getCell(1, 1), spear);
        fighter = new Fighter(150, 2, field.getCell(1, 1), axe);
        alpaca = new Alpaca(150, 2, field.getCell(1, 1), axe, spear, anima, sword);
        cleric = new Cleric(150, 2, field.getCell(1, 1), staff);
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

        sorcerer3.equipItem(anima);
        archer.equipItem(bow);
        archer.attack(sorcerer3);
        assertEquals(555, sorcerer3.getCurrentHitPoints());
        assertEquals(105, archer.getCurrentHitPoints());

        fighter.equipItem(axe);
        fighter.attack(sorcerer3);
        assertEquals(510, sorcerer3.getCurrentHitPoints());
        assertEquals(105, fighter.getCurrentHitPoints());

        hero.equipItem(spear);
        hero.attack(sorcerer3);
        assertEquals(465, sorcerer3.getCurrentHitPoints());
        assertEquals(105, hero.getCurrentHitPoints());

        swordMaster.equipItem(sword);
        swordMaster.attack(sorcerer3);
        assertEquals(420, sorcerer3.getCurrentHitPoints());
        assertEquals(105, swordMaster.getCurrentHitPoints());


        sorcerer3.equipItem(luz);
        archer.attack(sorcerer3);
        assertEquals(375, sorcerer3.getCurrentHitPoints());
        assertEquals(60, archer.getCurrentHitPoints());

        fighter.attack(sorcerer3);
        assertEquals(330, sorcerer3.getCurrentHitPoints());
        assertEquals(60, fighter.getCurrentHitPoints());

        hero.attack(sorcerer3);
        assertEquals(285, sorcerer3.getCurrentHitPoints());
        assertEquals(60, hero.getCurrentHitPoints());

        swordMaster.attack(sorcerer3);
        assertEquals(240, sorcerer3.getCurrentHitPoints());
        assertEquals(60, swordMaster.getCurrentHitPoints());


        sorcerer3.equipItem(oscuridad);
        archer.attack(sorcerer3);
        assertEquals(195, sorcerer3.getCurrentHitPoints());
        assertEquals(15, archer.getCurrentHitPoints());

        fighter.attack(sorcerer3);
        assertEquals(150, sorcerer3.getCurrentHitPoints());
        assertEquals(15, fighter.getCurrentHitPoints());

        hero.attack(sorcerer3);
        assertEquals(105, sorcerer3.getCurrentHitPoints());
        assertEquals(15, hero.getCurrentHitPoints());

        swordMaster.attack(sorcerer3);
        assertEquals(60, sorcerer3.getCurrentHitPoints());
        assertEquals(15, swordMaster.getCurrentHitPoints());



    }
}