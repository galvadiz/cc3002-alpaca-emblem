package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.NullItem;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {

  private Hero hero, hero2;
  private Fighter fighter;
  private Archer archer;
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
    hero = new Hero(300, 2, field.getCell(0, 0), spear, axe, bow);
    fighter = new Fighter(300, 2, field.getCell(1, 1), axe);
    archer = new Archer(300, 2, field.getCell(1, 2), bow);
    swordMaster = new SwordMaster(100, 2, field.getCell(1, 1), spear, sword, axe);
    hero2 = new Hero(300, 2, field.getCell(1, 1), spear2);
    sorcerer = new Sorcerer(100, 2, field.getCell(1, 1), anima, luz, oscuridad);
    alpaca = new Alpaca(100, 2, field.getCell(1, 1), axe, spear, anima, sword);
    cleric = new Cleric(100, 2, field.getCell(1, 1), staff);
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  @Override
  @Test
  public void equipSpearTest() {
    assertEquals(new NullItem(), hero.getEquippedItem());
    hero.equipItem(spear);
    assertEquals(spear, hero.getEquippedItem());
  }

  @Test
  @Override
  public void attackTest() {
    assertEquals(300, hero.getCurrentHitPoints());
    hero2.attack(hero);
    assertEquals(300, hero.getCurrentHitPoints());

    hero2.equipItem(spear2);
    hero2.attack(hero);
    assertEquals(270, hero.getCurrentHitPoints());

    hero.equipItem(spear);
    hero2.attack(hero);
    assertEquals(240, hero.getCurrentHitPoints());

    swordMaster.equipItem(sword);
    swordMaster.attack(hero);
    assertEquals(230, hero.getCurrentHitPoints());

    fighter.equipItem(axe);
    fighter.attack(hero);
    assertEquals(185, hero.getCurrentHitPoints());

    archer.equipItem(bow);
    archer.attack(hero);
    assertEquals(155, hero.getCurrentHitPoints());

    sorcerer.equipItem(anima);
    sorcerer.attack(hero);
    assertEquals(110, hero.getCurrentHitPoints());

    sorcerer.equipItem(luz);
    sorcerer.attack(hero);
    assertEquals(65, hero.getCurrentHitPoints());

    sorcerer.equipItem(oscuridad);
    sorcerer.attack(hero);
    assertEquals(20, hero.getCurrentHitPoints());


  }
}