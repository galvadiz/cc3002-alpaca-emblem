package model.items;

import model.units.*;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractItemNoAttack {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * {@inheritDoc}
   *
   * equip staff to unit
   */
  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipStaff(this);
  }

  @Override
  public void useItem(IUnit unit) {
    unit.receiveHeal(this);
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
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Staff)) return false;
    Staff that = (Staff) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
