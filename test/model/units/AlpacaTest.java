package model.units;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;

  @Override
  public void setTestUnit() {
    this.setWeapons();
    alpaca = new Alpaca(100, 2, field.getCell(0, 0), axe);
  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }
}