package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents a <i>SwordMaster</i> type unit.
 * <p>
 * A <i>SwordMaster</i> is a unit that <b>can only use sword type weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordMaster extends AbstractUnit {

  /**
   * Creates a new swordMaster
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
  public SwordMaster(int hitPoints, int movement, Location location, IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * {@inheritDoc}
   *
   * swordMaster only can equip sword
   */
  @Override
  public void equipSword(Sword sword){
    equippedItem = sword;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof SwordMaster)) return false;
    SwordMaster that = (SwordMaster) o;
    return this.getCurrentHitPoints() == that.getCurrentHitPoints() &&
            this.getMovement() == that.getMovement() &&
            this.getHitPointsMax() == that.getHitPointsMax() &&
            //getLocation().getColumn() == that.getLocation().getColumn() &&
            //getLocation().getRow() == that.getLocation().getRow() &&
            getEquippedItem().equals(that.getEquippedItem()) &&
            getItems().equals(that.getItems());
  }
}
