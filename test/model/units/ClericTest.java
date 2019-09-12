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
  private Fighter fighter;
  private Sorcerer sorcerer;


  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    this.setWeapons();
    cleric = new Cleric(300, 2, field.getCell(0, 0), staff, staff2, sword);
    archer = new Archer(300, 2, field.getCell(1, 1), staff, bow, sword);
    fighter = new Fighter(300, 2, field.getCell(0, 0), axe, bow, sword);
    sorcerer = new Sorcerer(300, 2, field.getCell(1, 1), anima, luz, oscuridad);
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

    cleric.equipItem(staff2);
    archer.attack(cleric);
    assertEquals(300, cleric.getCurrentHitPoints());

    archer.equipItem(bow);
    archer.attack(cleric);
    assertEquals(270, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());

    cleric.attack(archer);
    assertEquals(270, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());

    fighter.equipItem(axe);
    archer.attack(fighter);
    assertEquals(270, fighter.getCurrentHitPoints());
    assertEquals(270, archer.getCurrentHitPoints());

    cleric.heal(archer);
    assertEquals(300, archer.getCurrentHitPoints());

    sorcerer.equipItem(anima);
    sorcerer.attack(cleric);
    assertEquals(225, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());

    sorcerer.equipItem(luz);
    sorcerer.attack(cleric);
    assertEquals(180, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());

    sorcerer.equipItem(oscuridad);
    sorcerer.attack(cleric);
    assertEquals(135, cleric.getCurrentHitPoints());
    assertEquals(300, archer.getCurrentHitPoints());

    cleric.equipItem(staff);
    cleric.heal(fighter);
      assertEquals(300, fighter.getCurrentHitPoints());
  }
}