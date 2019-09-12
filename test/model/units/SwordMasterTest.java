package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster, swordMaster2;
  private Hero hero;
  private Fighter fighter;
  private Archer archer;
  private Sorcerer sorcerer;
  private Alpaca alpaca;
  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    this.setWeapons();
    swordMaster = new SwordMaster(300, 2, field.getCell(0, 0), spear, sword, axe);
    hero = new Hero(100, 2, field.getCell(1, 1), spear);
    fighter = new Fighter(300, 2, field.getCell(1, 1), axe);
    archer = new Archer(300, 2, field.getCell(1, 2), bow);
    swordMaster2 = new SwordMaster(100, 2, field.getCell(1, 1), spear, sword2, axe);
    sorcerer = new Sorcerer(100, 2, field.getCell(1, 1), anima, luz, oscuridad);
    alpaca = new Alpaca(100, 2, field.getCell(1, 1), axe, spear, anima, sword);
    cleric = new Cleric(100, 2, field.getCell(1, 1), staff);
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
    assertEquals(300, swordMaster.getCurrentHitPoints());
    swordMaster2.attack(swordMaster);
    assertEquals(300, swordMaster.getCurrentHitPoints());

    swordMaster2.equipItem(sword2);
    swordMaster2.attack(swordMaster);
    assertEquals(270, swordMaster.getCurrentHitPoints());

    swordMaster.equipItem(sword);
    swordMaster2.attack(swordMaster);
    assertEquals(240, swordMaster.getCurrentHitPoints());

    hero.equipItem(spear);
    hero.attack(swordMaster);
    assertEquals(195, swordMaster.getCurrentHitPoints());

    fighter.equipItem(axe);
    fighter.attack(swordMaster);
    assertEquals(185, swordMaster.getCurrentHitPoints());

    archer.equipItem(bow);
    archer.attack(swordMaster);
    assertEquals(155, swordMaster.getCurrentHitPoints());

    sorcerer.equipItem(anima);
    sorcerer.attack(swordMaster);
    assertEquals(110, swordMaster.getCurrentHitPoints());

    sorcerer.equipItem(luz);
    sorcerer.attack(swordMaster);
    assertEquals(65, swordMaster.getCurrentHitPoints());

    sorcerer.equipItem(oscuridad);
    sorcerer.attack(swordMaster);
    assertEquals(20, swordMaster.getCurrentHitPoints());
  }
}