package model.units;

import model.items.*;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an <i>Archer</i> type unit.
 * <p>
 * This kind of unit <b>can only use bows</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Archer extends AbstractUnit {

  /**
   * Creates a new archer
   *
   * @param hitPoints
   *     maximum hit points of the unit
   * @param movement
   *     the amount of cells this unit can move
   * @param position
   *     the initial position of this unit
   * @param items
   *     the items carried by this unit
   */
  public Archer(final int hitPoints, final int movement, final Location position,
      final IEquipableItem... items) {
    super(hitPoints, movement, position, 3, items);
  }

  /**
   *{@inheritDoc}
   *
   * archer only can equip bow
   */
  public void equipBow(Bow bow){
    equippedItem = bow;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Archer)) return false;
    Archer that = (Archer) o;
    return this.getCurrentHitPoints() == that.getCurrentHitPoints() &&
            this.getMovement() == that.getMovement() &&
            this.getHitPointsMax() == that.getHitPointsMax() &&
            //getLocation().getColumn() == that.getLocation().getColumn() &&
            //getLocation().getRow() == that.getLocation().getRow() &&
            getEquippedItem().equals(that.getEquippedItem()) &&
            getItems().equals(that.getItems());
  }

}
