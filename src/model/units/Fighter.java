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

  public Fighter(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }


  public void equipAxe(Axe axe){
    for (IEquipableItem i: this.getItems()){
      if(axe.equals(i)){
        equippedItem = axe;
        return;
      }
    }
    axe.setOwner(null);
  }

  public void attack(IUnit unit){
    if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
            && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange()){
      equippedItem.attackTo(unit);
    }
  }

  @Override
  public void receiveSwordAttack(IEquipableItem sword){
    if(equippedItem != null){
      super.receiveStrengthenedAttack(sword);
      return;
    }
    super.receiveSwordAttack(sword);
  }

  @Override
  public void receiveSpearAttack(IEquipableItem spear){
    if(equippedItem != null){
      super.receiveWeakenedAttack(spear);
      return;
    }
    super.receiveSpearAttack(spear);
  }

  @Override
  public void receiveAnimaAttack(IEquipableItem anima){
    if(equippedItem != null){
      super.receiveStrengthenedAttack(anima);
      return;
    }
    super.receiveAnimaAttack(anima); }

  @Override
  public void receiveLuzAttack(IEquipableItem luz){
    if(equippedItem != null){
      super.receiveStrengthenedAttack(luz);
      return;
    }
    super.receiveLuzAttack(luz); }

  @Override
  public void receiveOscuridadAttack(IEquipableItem oscuridad){
    if(equippedItem != null){
      super.receiveStrengthenedAttack(oscuridad);
      return;
    }
    super.receiveOscuridadAttack(oscuridad); }
}
