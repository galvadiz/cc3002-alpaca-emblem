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

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
    hero = new Hero(50, 2, field.getCell(1, 1));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Override
  public void equipSwordTest() {
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(sword);
    assertEquals(sword, swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void attackTest() {
    assertEquals(50, swordMaster.getCurrentHitPoints());
    hero.equipItem(spear);
    swordMaster.equipItem(sword);
    hero.attack(swordMaster);
    assertEquals(35, swordMaster.getCurrentHitPoints());
  }
}