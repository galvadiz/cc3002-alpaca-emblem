package model.units;

import model.items.*;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Fighter extends AbstractUnit {

  /**
   * Creates a new fighter
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
  public Fighter(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   *{@inheritDoc}
   *
   * fighter only can equip axe
   *
   */
  public void equipAxe(Axe axe){
        equippedItem = axe;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Fighter)) return false;
    Fighter that = (Fighter) o;
    return this.getCurrentHitPoints() == that.getCurrentHitPoints() &&
            this.getMovement() == that.getMovement() &&
            this.getHitPointsMax() == that.getHitPointsMax() &&
            //getLocation().getColumn() == that.getLocation().getColumn() &&
            //getLocation().getRow() == that.getLocation().getRow() &&
            getEquippedItem().equals(that.getEquippedItem()) &&
            getItems().equals(that.getItems());
  }

}
