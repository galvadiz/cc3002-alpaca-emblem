package model.items;

import model.units.IUnit;
import model.units.*;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and magic items but weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractItemAttack {

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

  /**
   * {@inheritDoc}
   *
   * equip sword to unit
   */
  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipSword(this);
  }

  /**
   * {@inheritDoc}
   *
   * attack the unit with a sword.
   */
  @Override
  public void attackTo(IUnit unit){
    unit.receiveSwordAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * contra attack the unit with a sword.
   */
  @Override
  public void contraAttackTo(IUnit unit){
    unit.receiveSwordContraAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from a spear.
   */
  @Override
  public void receiveSpearAttackItem(IEquipableItem spear){
    getOwner().receiveStrengthenedAttack(spear);
  }

  /**
   * {@inheritDoc}
   *
   * receive weakened attack from an axe.
   */
  @Override
  public void receiveAxeAttackItem(IEquipableItem axe){
    getOwner().receiveWeakenedAttack(axe);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from luz.
   */
  @Override
  public void receiveLuzAttackItem(IEquipableItem luz){
    getOwner().receiveStrengthenedAttack(luz);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from anima.
   */
  @Override
  public void receiveAnimaAttackItem(IEquipableItem anima){
    getOwner().receiveStrengthenedAttack(anima);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from oscuridad.
   */
  @Override
  public void receiveOscuridadAttackItem(IEquipableItem oscuridad){
    getOwner().receiveStrengthenedAttack(oscuridad);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from a spear.
   */
  @Override
  public void receiveSpearContraAttackItem(IEquipableItem spear){
    getOwner().receiveStrengthenedAttack(spear);
  }

  /**
   * {@inheritDoc}
   *
   * receive weakened contra attack from an axe.
   */
  @Override
  public void receiveAxeContraAttackItem(IEquipableItem axe){
    getOwner().receiveWeakenedAttack(axe);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from luz.
   */
  @Override
  public void receiveLuzContraAttackItem(IEquipableItem luz){
    getOwner().receiveStrengthenedAttack(luz);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from anima.
   */
  @Override
  public void receiveAnimaContraAttackItem(IEquipableItem anima){
    getOwner().receiveStrengthenedAttack(anima);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened contra attack from oscuridad.
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
    if (!(o instanceof Sword)) return false;
    Sword that = (Sword) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
