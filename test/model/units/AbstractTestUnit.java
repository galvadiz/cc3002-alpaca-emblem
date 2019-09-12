package model.units;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow, bow2;
  protected Field field;
  protected Axe axe, axe2;
  protected Sword sword, sword2;
  protected Staff staff, staff2;
  protected Spear spear, spear2;
  protected IMagia anima, anima2, luz, luz2, oscuridad, oscuridad2;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 30, 1, 2);
    this.sword = new Sword("Sword", 30, 1, 2);
    this.spear = new Spear("Spear", 30, 1, 2);
    this.staff = new Staff("Staff", 30, 1, 2);
    this.bow = new Bow("Bow", 30, 2, 3);
    this.anima = new Anima("Anima", 30, 1, 2);
    this.luz = new Luz("Luz", 30, 1, 2);
    this.oscuridad = new Oscuridad("Oscuridad", 30, 1, 2);

    this.axe2 = new Axe("Axe2", 30, 1, 2);
    this.sword2 = new Sword("Sword2", 30, 1, 2);
    this.spear2 = new Spear("Spear2", 30, 1, 2);
    this.staff2 = new Staff("Staff2", 60, 1, 2);
    this.bow2 = new Bow("Bow2", 30, 2, 3);
    this.anima2 = new Anima("Anima2", 30, 1, 2);
    this.luz2 = new Luz("Luz2", 30, 1, 2);
    this.oscuridad2 = new Oscuridad("Oscuridad2", 30, 1, 2);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(300, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertFalse(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  @Override
  @Test
  public void equipAnimaTest() {
    checkEquippedItem(getAnima());
  }

  /**
   * @return the test bow
   */
  @Override
  public IMagia getAnima() {
    return anima;
  }

  @Override
  @Test
  public void equipLuzTest() {
    checkEquippedItem(getLuz());
  }

  /**
   * @return the test bow
   */
  @Override
  public IMagia getLuz() {
    return luz;
  }

  @Override
  @Test
  public void equipOscuridadTest() {
    checkEquippedItem(getOscuridad());
  }

  /**
   * @return the test bow
   */
  @Override
  public IMagia getOscuridad() {
    return oscuridad;
  }


  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Override
  @Test
  public void attackTest(){

  }
}
