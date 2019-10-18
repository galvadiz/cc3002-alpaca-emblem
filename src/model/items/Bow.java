package model.items;

import model.units.*;

/**
 * This class represents an Bow.
 * <p>
 * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
 * one.
 *
 * Bows are strong against magias.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public class Bow extends AbstractItemAttack {

  /**
   * Creates a new bow.
   * <p>
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
    this.setMinRange(Math.max(minRange, 2));
    this.setMaxRange(Math.max(maxRange, this.getMinRange()));
  }

  /**
   * {@inheritDoc}
   *
   * equip bow to unit
   */
  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipBow(this);
  }

  /**
   * {@inheritDoc}
   *
   * attack the unit with a bow
   */
  @Override
  public void attackTo(IUnit unit){
    unit.receiveBowAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * contra attack the unit with an bow
   */
  @Override
  public void contraAttackTo(IUnit unit){
    unit.receiveBowContraAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from luz
   */
  @Override
  public void receiveLuzAttackItem(IEquipableItem luz){
    getOwner().receiveStrengthenedAttack(luz);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from anima
   */
  @Override
  public void receiveAnimaAttackItem(IEquipableItem anima){
    getOwner().receiveStrengthenedAttack(anima);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from oscuridad
   */
  @Override
  public void receiveOscuridadAttackItem(IEquipableItem oscuridad){
    getOwner().receiveStrengthenedAttack(oscuridad);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from luz
   */
  @Override
  public void receiveLuzContraAttackItem(IEquipableItem luz){
    getOwner().receiveStrengthenedAttack(luz);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from anima
   */
  @Override
  public void receiveAnimaContraAttackItem(IEquipableItem anima){
    getOwner().receiveStrengthenedAttack(anima);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from oscuridad
   */
  @Override
  public void receiveOscuridadContraAttackItem(IEquipableItem oscuridad){
    getOwner().receiveStrengthenedAttack(oscuridad);
  }

  /**
   * {@inheritDoc}
   */
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
