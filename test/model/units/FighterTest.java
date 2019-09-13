package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter, fighter2;
  private Archer archer;
  private Hero hero;
  private SwordMaster swordMaster;
  private Sorcerer sorcerer;
  private Alpaca alpaca;
  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    this.setWeapons();
    fighter = new Fighter(300, 2, field.getCell(0, 0), axe);
    archer = new Archer(300, 2, field.getCell(1, 2), bow);
    swordMaster = new SwordMaster(100, 2, field.getCell(1, 1), spear, sword, axe, luz, anima);
    hero = new Hero(100, 2, field.getCell(1, 1), spear);
    fighter2 = new Fighter(100, 2, field.getCell(1, 1), axe2, axe3);
    sorcerer = new Sorcerer(100, 2, field.getCell(1, 1), anima, luz, oscuridad);
    alpaca = new Alpaca(100, 2, field.getCell(1, 1), axe, spear, anima, sword);
    cleric = new Cleric(100, 2, field.getCell(1, 1), staff);
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(axe);
    assertEquals(axe, fighter.getEquippedItem());
  }

  @Test
  @Override
  public void attackTest() {
    assertEquals(300, fighter.getCurrentHitPoints());
    fighter2.attack(fighter);
    assertEquals(300, fighter.getCurrentHitPoints());
    fighter2.equipItem(axe2);
    fighter2.attack(fighter);
    assertEquals(270, fighter.getCurrentHitPoints());
    fighter.equipItem(axe);
    fighter2.attack(fighter);
    assertEquals(240, fighter.getCurrentHitPoints());
    swordMaster.equipItem(sword);
    swordMaster.attack(fighter);
    assertEquals(195, fighter.getCurrentHitPoints());
    assertEquals(90, swordMaster.getCurrentHitPoints());

    hero.equipItem(spear);
    hero.attack(fighter);
    assertEquals(185, fighter.getCurrentHitPoints());

    archer.equipItem(bow);
    archer.attack(fighter);
    assertEquals(155, fighter.getCurrentHitPoints());

    sorcerer.equipItem(anima);
    sorcerer.attack(fighter);
    assertEquals(110, fighter.getCurrentHitPoints());

    sorcerer.equipItem(luz);
    sorcerer.attack(fighter);
    assertEquals(65, fighter.getCurrentHitPoints());

    sorcerer.equipItem(oscuridad);
    sorcerer.attack(fighter);
    assertEquals(20, fighter.getCurrentHitPoints());

    fighter2.equipItem(axe3);
    fighter2.attack(swordMaster);
    assertEquals(90, swordMaster.getCurrentHitPoints());

  }
}