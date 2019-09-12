package model.items;

import model.units.IUnit;
import model.units.*;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractItem {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public Sword(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipSword(this);
  }

  @Override
  public void attackTo(IUnit unit){
    unit.receiveSwordAttack(this);
  }

  @Override
  public void receiveSpearAttackItem(IEquipableItem spear){
    getOwner().receiveStrengthenedAttack(spear);
  }

  @Override
  public void receiveAxeAttackItem(IEquipableItem axe){
    getOwner().receiveWeakenedAttack(axe);
  }

  @Override
  public void receiveLuzAttackItem(IEquipableItem luz){
    getOwner().receiveStrengthenedAttack(luz);
  }

  @Override
  public void receiveAnimaAttackItem(IEquipableItem anima){
    getOwner().receiveStrengthenedAttack(anima);
  }

  @Override
  public void receiveOscuridadAttackItem(IEquipableItem oscuridad){
    getOwner().receiveStrengthenedAttack(oscuridad);
  }


  @Override
  public boolean equals(Object o){
    if (o == null) return false;
    if (this == o) return true;
    if (!(o instanceof Sword)) return false;
    Sword that = (Sword) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
