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
   *
   * @param bow
   */
  public void equipBow(Bow bow){
    equippedItem = bow;
  }

  public void attack(IUnit unit){
    if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
            && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange()){
      unit.receiveBowAttack(equippedItem);
    }
  }
}
