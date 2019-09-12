package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;
  private Archer archer;

  @Override
  public void setTestUnit() {
    this.setWeapons();
    alpaca = new Alpaca(300, 2, field.getCell(0, 0), axe);
    archer = new Archer(300, 2, field.getCell(0, 1));

  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }


  @Test
  public void intercambioTest(){
    alpaca.addItem(sword);
    alpaca.addItem(sword2);
    alpaca.addItem(spear);
    alpaca.addItem(spear2);
    assertTrue(alpaca.hayEspacio());

    archer.addItem(bow);
    alpaca.darItem(archer, sword);

    assertFalse(alpaca.estaItem(sword));
    assertTrue(archer.estaItem(sword));

    assertTrue(archer.hayEspacio());

    alpaca.darItem(archer, spear);

    assertFalse(alpaca.estaItem(spear));
    assertTrue(archer.estaItem(spear));

    assertFalse(archer.hayEspacio());

  }
}