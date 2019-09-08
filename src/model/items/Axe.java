package model.items;

import model.units.*;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipAxe(this);
  }

  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Axe)) return false;
    Axe that = (Axe) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
