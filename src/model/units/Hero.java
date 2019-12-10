package model.units;

import model.items.IEquipableItem;
import model.items.*;
import model.map.Location;

/**
 * A <i>Hero</i> is a special kind of unit, the player that defeats this unit wins the game.
 * <p>
 * This unit <b>can only use spear weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Hero extends AbstractUnit {

  /**
   * Creates a new hero
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
  public Hero(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * {@inheritDoc}
   *
   * hero only can equip spear
   */
  @Override
  public void equipSpear(Spear spear){
    equippedItem = spear;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Hero)) return false;
    Hero that = (Hero) o;
    return this.getCurrentHitPoints() == that.getCurrentHitPoints() &&
            this.getMovement() == that.getMovement() &&
            this.getHitPointsMax() == that.getHitPointsMax() &&
            //getLocation().getColumn() == that.getLocation().getColumn() &&
            //getLocation().getRow() == that.getLocation().getRow() &&
            getEquippedItem().equals(that.getEquippedItem()) &&
            getItems().equals(that.getItems());
  }
}
