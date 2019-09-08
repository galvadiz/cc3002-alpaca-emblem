package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster;
  private Hero hero;
  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    this.setWeapons();
    swordMaster = new SwordMaster(100, 2, field.getCell(0, 0), spear, sword, axe);
    hero = new Hero(100, 2, field.getCell(1, 1), spear);
    fighter = new Fighter(100, 2, field.getCell(1, 1), axe);
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Override
  @Test
  public void equipSwordTest() {
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(sword);
    assertEquals(sword, swordMaster.getEquippedItem());
  }


  @Override
  @Test
  public void attackTest() {
    assertEquals(100, swordMaster.getCurrentHitPoints());
    hero.equipItem(spear);
    fighter.equipItem(axe);
    swordMaster.equipItem(sword);
    hero.attack(swordMaster);
    assertEquals(55, swordMaster.getCurrentHitPoints());
    fighter.attack(swordMaster);
    assertEquals(45, swordMaster.getCurrentHitPoints());
  }
}