package model.items;

import model.units.*;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
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

  @Override
  public void equipTo(IUnit unit){
    super.setOwner(unit);
    unit.equipAxe(this);
  }

  @Override
  public void attackTo(IUnit unit){
    unit.receiveAxeAttack(this);
  }

  @Override
  public void contraAttackTo(IUnit unit){
    unit.receiveAxeContraAttack(this);
  }

  @Override
  public void receiveSwordAttackItem(IEquipableItem sword){
    getOwner().receiveStrengthenedAttack(sword);
  }

  @Override
  public void receiveSpearAttackItem(IEquipableItem spear){
    getOwner().receiveWeakenedAttack(spear);
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
  public void receiveSwordContraAttackItem(IEquipableItem sword){
    getOwner().receiveStrengthenedAttack(sword);
  }

  @Override
  public void receiveSpearContraAttackItem(IEquipableItem spear){
    getOwner().receiveWeakenedAttack(spear);
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
    if (!(o instanceof Axe)) return false;
    Axe that = (Axe) o;
    return this.getPower() == that.getPower() &&
            this.getMinRange() == that.getMinRange() &&
            this.getMaxRange() == that.getMaxRange() &&
            getName().equals(that.getName());
  }

}
