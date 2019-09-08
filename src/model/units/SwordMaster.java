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

  public SwordMaster(int hitPoints, int movement, Location location, IEquipableItem... items) {
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

  @Override
  public void receiveAxeAttack(IEquipableItem axe){
    if(equippedItem != null){
      this.receiveWeakenedAttack(axe);
      return;
    }
    super.receiveAxeAttack(axe);
  }

  //@Override
  //public boolean equals(Object o) {
  //  if (this == o) return true;
  //  if (!(o instanceof SwordMaster)) return false;
  //  SwordMaster that = (SwordMaster) o;
  //}
}
