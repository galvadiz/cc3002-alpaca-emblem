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
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Hero(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }


  @Override
  public void equipSpear(Spear spear){
    equippedItem = spear;
  }

  public void attack(IUnit unit){
    if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
            && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange()){
      unit.receiveSpearAttack(equippedItem);
    }
  }

  @Override
  public void receiveAxeAttack(IEquipableItem axe){
    if(equippedItem != null){
      super.receiveStrengthenedAttack(axe);
      return;
    }
    super.receiveAxeAttack(axe);
  }

  @Override
  public void receiveSwordAttack(IEquipableItem sword){
    if(equippedItem != null){
      super.receiveWeakenedAttack(sword);
      return;
    }
    super.receiveSwordAttack(sword);
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
