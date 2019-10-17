package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItemAttack extends IEquipableItem {

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

  /**
   * Performs the correct attack to the target Unit.
   * @param unit the target unit.
   */
  void attackTo(IUnit unit);

  /**
   * Performs the correct contra attack to the target Unit.
   * @param unit the target unit.
   */
  void contraAttackTo(IUnit unit);

  /**
   * Lets the Item be attacked by an anima.
   * @param item the item that attack this item.
   */
  void receiveAnimaAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be attacked by an luz.
   * @param item the item that attack this item.
   */
  void receiveLuzAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be attacked by an oscuridad.
   * @param item the item that attack this item.
   */
  void receiveOscuridadAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be attacked by an axe.
   * @param item the item that attack this item.
   */
  void receiveAxeAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be attacked by an bow.
   * @param item the item that attack this item.
   */
  void receiveBowAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be attacked by an spear.
   * @param item the item that attack this item.
   */
  void receiveSpearAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be attacked by an sword.
   * @param item the item that attack this item.
   */
  void receiveSwordAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an anima.
   * @param item the item that attack this item.
   */
  void receiveAnimaContraAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an luz.
   * @param item the item that attack this item.
   */
  void receiveLuzContraAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an oscuridad.
   * @param item the item that attack this item.
   */
  void receiveOscuridadContraAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an axe.
   * @param item the item that attack this item.
   */
  void receiveAxeContraAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an bow.
   * @param item the item that attack this item.
   */
  void receiveBowContraAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an spear.
   * @param item the item that attack this item.
   */
  void receiveSpearContraAttackItem(IEquipableItemAttack item);

  /**
   * Lets the Item be contra attacked by an sword.
   * @param item the item that attack this item.
   */
  void receiveSwordContraAttackItem(IEquipableItemAttack item);

}
