package model.items;

import model.units.*;

/**
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Bow extends AbstractItem {

  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipBow(this);
  }

  @Override
  public void attackTo(IUnit unit){
    unit.receiveBowAttack(this);
  }

  @Override
  public void contraAttackTo(IUnit unit){
    unit.receiveBowContraAttack(this);
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
  public void receiveLuzContraAttackItem(IEquipableItem luz){
    getOwner().receiveStrengthenedAttack(luz);
  }

  @Override
  public void receiveAnimaContraAttackItem(IEquipableItem anima){
    getOwner().receiveStrengthenedAttack(anima);
  }

  @Override
  public void receiveOscuridadContraAttackItem(IEquipableItem oscuridad){
    getOwner().receiveStrengthenedAttack(oscuridad);
  }


  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Bow)) return false;
    Bow that = (Bow) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
