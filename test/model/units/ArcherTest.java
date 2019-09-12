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
public class ArcherTest extends AbstractTestUnit {

  private Archer archer;
  private Archer archer2;
  private Fighter fighter;
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
    archer = new Archer(300, 2, field.getCell(0, 0), bow);
    archer2 = new Archer(100, 2, field.getCell(1, 2), bow);
    swordMaster = new SwordMaster(100, 2, field.getCell(1, 1), spear, sword, axe);
    hero = new Hero(100, 2, field.getCell(1, 1), spear);
    fighter = new Fighter(100, 2, field.getCell(1, 1), axe);
    sorcerer = new Sorcerer(100, 2, field.getCell(1, 1), anima, luz, oscuridad);
    alpaca = new Alpaca(100, 2, field.getCell(1, 1), axe, spear, anima, sword);
    cleric = new Cleric(100, 2, field.getCell(1, 1), staff);
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    assertNull(archer.getEquippedItem());
    archer.equipItem(bow);
    assertEquals(bow, archer.getEquippedItem());
  }

  @Test
  @Override
  public void attackTest() {
    assertEquals(300, archer.getCurrentHitPoints());
    archer2.attack(archer);
    assertEquals(300, archer.getCurrentHitPoints());

    archer2.equipItem(bow2);
    archer2.attack(archer);
    assertEquals(270, archer.getCurrentHitPoints());

    archer.equipItem(bow);
    archer2.attack(archer);
    assertEquals(240, archer.getCurrentHitPoints());

    swordMaster.equipItem(sword);
    swordMaster.attack(archer);
    assertEquals(210, archer.getCurrentHitPoints());

    hero.equipItem(spear);
    hero.attack(archer);
    assertEquals(180, archer.getCurrentHitPoints());

    fighter.equipItem(axe);
    fighter.attack(archer);
    assertEquals(150, archer.getCurrentHitPoints());

    sorcerer.equipItem(anima);
    sorcerer.attack(archer);
    assertEquals(105, archer.getCurrentHitPoints());

    sorcerer.equipItem(luz);
    sorcerer.attack(archer);
    assertEquals(60, archer.getCurrentHitPoints());

    sorcerer.equipItem(oscuridad);
    sorcerer.attack(archer);
    assertEquals(15, archer.getCurrentHitPoints());


  }
}