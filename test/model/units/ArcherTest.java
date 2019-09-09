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
    archer = new Archer(100, 2, field.getCell(0, 0), bow);
    archer2 = new Archer(100, 2, field.getCell(1, 2), bow);
    swordMaster = new SwordMaster(100, 2, field.getCell(1, 2), spear, sword, axe);
    hero = new Hero(100, 2, field.getCell(1, 2), spear);
    fighter = new Fighter(100, 2, field.getCell(1, 2), axe);
    sorcerer = new Sorcerer(100, 2, field.getCell(1, 2), magia);
    alpaca = new Alpaca(100, 2, field.getCell(1, 2), axe, spear, magia, sword);
    cleric = new Cleric(100, 2, field.getCell(1, 2), staff);
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
    assertEquals(100, archer.getCurrentHitPoints());
    archer.equipItem(bow);
    archer2.equipItem(bow);
    archer2.attack(archer);
    assertEquals(70, archer.getCurrentHitPoints());

  }
}