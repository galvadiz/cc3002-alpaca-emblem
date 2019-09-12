package model.items;

import model.units.*;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Spear extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipSpear(this);
  }

  @Override
  public void attackTo(IUnit unit){
    unit.receiveSpearAttack(this);
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
  public void receiveAxeAttackItem(IEquipableItem axe){
    getOwner().receiveStrengthenedAttack(axe);
  }


  @Override
  public void receiveSwordAttackItem(IEquipableItem sword){
    getOwner().receiveWeakenedAttack(sword);
  }

  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Spear)) return false;
    Spear that = (Spear) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
