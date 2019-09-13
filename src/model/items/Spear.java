package model.items;

import model.units.*;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and magic items but weak against axes
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

  /**
   * {@inheritDoc}
   *
   * equip spear to unit
   */
  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipSpear(this);
  }

  /**
   * {@inheritDoc}
   *
   * attack the unit with a spear.
   */
  @Override
  public void attackTo(IUnit unit){
    unit.receiveSpearAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * contra attack the unit with a spear.
   */
  @Override
  public void contraAttackTo(IUnit unit){
    unit.receiveSpearContraAttack(this);
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
   * receive strengthened attack from an axe
   */
  @Override
  public void receiveAxeAttackItem(IEquipableItem axe){
    getOwner().receiveStrengthenedAttack(axe);
  }

  /**
   * {@inheritDoc}
   *
   * receive weakened attack from sword
   */
  @Override
  public void receiveSwordAttackItem(IEquipableItem sword){
    getOwner().receiveWeakenedAttack(sword);
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
   *
   * receive strengthened contra attack from axe
   */
  @Override
  public void receiveAxeContraAttackItem(IEquipableItem axe){
    getOwner().receiveStrengthenedAttack(axe);
  }

  /**
   * {@inheritDoc}
   *
   * receive weakened contra attack from sword
   */
  @Override
  public void receiveSwordContraAttackItem(IEquipableItem sword){
    getOwner().receiveWeakenedAttack(sword);
  }

  /**
   * {@inheritDoc}
   *
   */
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
