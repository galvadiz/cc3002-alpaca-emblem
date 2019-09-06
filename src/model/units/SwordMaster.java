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

  public SwordMaster(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  public void equipSword(Sword sword){
    equippedItem = sword;
  }

  public void attack(IUnit unit){
    if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
            && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange()){
      unit.receiveSwordAttack(equippedItem);
    }
  }

  @Override
  public void receiveSpearAttack(IEquipableItem spear){
    if(equippedItem != null){
      this.receiveStrengthenedAttack(spear);
      return;
    }
    super.receiveSpearAttack(spear);
  }

}
