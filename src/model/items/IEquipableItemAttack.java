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
   * Performs the correct attack to the target Unit.
   * @param unit the target unit.
   */
  void attackTo(IUnit unit);

  /**
   * Performs the correct contra attack to the target Unit.
   * @param unit the target unit.
   */
  void contraAttackTo(IUnit unit);




}
