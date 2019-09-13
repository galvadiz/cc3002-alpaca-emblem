package model.items;

import model.units.*;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears and magia but weak agains swords.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public class Axe extends AbstractItem {

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
  public Axe(String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipAxe(this);
  }

  /**
   * {@inheritDoc}
   *
   * attack the unit with an axe
   */
  @Override
  public void attackTo(IUnit unit){
    unit.receiveAxeAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * contra attack the unit with an axe
   */
  @Override
  public void contraAttackTo(IUnit unit){
    unit.receiveAxeContraAttack(this);
  }

  /**
   * {@inheritDoc}
   *
   * receive strengthened attack from sword
   */
  @Override
  public void receiveSwordAttackItem(IEquipableItem sword){
    getOwner().receiveStrengthenedAttack(sword);
  }

  /**
   * {@inheritDoc}
   *
   * receive weakened attack from spear
   */
  @Override
  public void receiveSpearAttackItem(IEquipableItem spear){
    getOwner().receiveWeakenedAttack(spear);
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
   * receive strengthened contra attack from sword
   */
  @Override
  public void receiveSwordContraAttackItem(IEquipableItem sword){
    getOwner().receiveStrengthenedAttack(sword);
  }

  /**
   * {@inheritDoc}
   *
   * receive weakened contra attack from spear
   */
  @Override
  public void receiveSpearContraAttackItem(IEquipableItem spear){
    getOwner().receiveWeakenedAttack(spear);
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
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Axe)) return false;
    Axe that = (Axe) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
