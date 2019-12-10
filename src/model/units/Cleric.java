package model.units;

import model.items.*;
import model.items.Staff;
import model.map.Location;

/**
 * This class represents a cleric type unit. A cleric can only use staff type weapons, which means
 * that it can receive attacks but can't counter attack any of those.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new cleric
   *
   * @param hitPoints
   *     maximum hit points of the unit
   * @param movement
   *     the amount of cells this unit can move
   * @param location
   *     the initial position of this unit
   * @param items
   *     the items carried by this unit
   */
  public Cleric(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }


  /**
   * {@inheritDoc}
   *
   * cleric only can equip staff
   */
  public void equipStaff(Staff staff){
    equippedItem = staff;
  }

  /**
   * {@inheritDoc}
   *
   */
  public void heal(IUnit unit) {
    this.getEquippedItem().useItem(unit);
  }

}
