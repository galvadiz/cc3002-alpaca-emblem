package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;
  private Archer archer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    this.setWeapons();
    cleric = new Cleric(300, 2, field.getCell(0, 0), staff, bow, sword);
    archer = new Archer(300, 2, field.getCell(1, 1), staff, bow, sword);
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }

  @Test
  @Override
  public void attackTest(){
    assertEquals(300, cleric.getCurrentHitPoints());
    archer.attack(cleric);
    assertEquals(300, cleric.getCurrentHitPoints());

    cleric.equipItem(staff);
    archer.attack(cleric);
    assertEquals(300, cleric.getCurrentHitPoints());

    archer.equipItem(bow);
    archer.attack(cleric);
    assertEquals(270, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());

    cleric.attack(archer);
    assertEquals(270, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());



  }
}