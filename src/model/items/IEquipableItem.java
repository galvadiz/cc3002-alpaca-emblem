package model.items;

import model.units.Hero;
import model.units.IUnit;
import model.units.*;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

  /**
   * @param unit
   */
  void setOwner(IUnit unit);

  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  void attackTo(IUnit unit);

  void receiveAnimaAttackItem(IEquipableItem item);

  void receiveLuzAttackItem(IEquipableItem item);

  void receiveOscuridadAttackItem(IEquipableItem item);

  void receiveAxeAttackItem(IEquipableItem item);

  void receiveBowAttackItem(IEquipableItem item);

  void receiveSpearAttackItem(IEquipableItem item);

  void receiveSwordAttackItem(IEquipableItem item);


  @Override
  boolean equals(Object o);
}
