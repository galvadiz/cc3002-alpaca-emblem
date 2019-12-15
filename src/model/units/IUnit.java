package model.units;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import model.items.IEquipableItem;
import model.items.*;
import model.map.Location;

import javax.imageio.event.IIOReadProgressListener;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  void equipItem(IEquipableItem item);

  /**
   * Sets axe of this unit.
   *
   * @param axe
   *     the item to equip
   */
  void equipAxe(Axe axe);

  /**
   * Sets bow of this unit.
   *
   * @param bow
   *     the item to equip
   */
  void equipBow(Bow bow);

  /**
   * Sets spear of this unit.
   *
   * @param spear
   *     the item to equip
   */
  void equipSpear(Spear spear);

  /**
   * Sets staff of this unit.
   *
   * @param staff
   *     the item to equip
   */
  void equipStaff(Staff staff);

  /**
   * Sets sword of this unit.
   *
   * @param sword
   *     the item to equip
   */
  void equipSword(Sword sword);

  /**
   * Sets magia of this unit.
   *
   * @param magia
   *     the item to equip
   */
  void equipMagia(IMagia magia);

  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

  /**
   * @return hit points of the unit
   */
  int getHitPointsMax();

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();


  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);

  /**
   * Shows if the Unit is Alive. If the currentHitPoints is higher than 0, returns true, else returns false.
   *
   * @return a boolean with the alive status.
   * */
  boolean isAlive();

  /**
   * Performs the correct attack to the target Unit.
   *
   * @param unit the target unit.
   */
  void attack(IUnit unit);

  /**
   * Performs the correct contra attack to the target Unit.
   *
   * @param unit the target unit.
   */
  void contraAttack(IUnit unit);

  /**
   * Lets the Unit receive a normal attack that doesn't has type-weakness or type-resistant to the item's unit that
   * performs it.
   * @param item the item that attack unit.
   */
  void receiveAttack(IEquipableItem item);

  /**
   * Lets the Unit be attacked by an axe.
   * @param axe the item that attack unit
   */
  void receiveAxeAttack(IEquipableItem axe);

  /**
   * Lets the Unit be attacked by an bow.
   * @param bow the item that attack unit
   */
  void receiveBowAttack(IEquipableItem bow);

  /**
   * Lets the Unit be attacked by an spear.
   * @param spear the item that attack unit
   */
  void receiveSpearAttack(IEquipableItem spear);

  /**
   * Lets the Unit be attacked by an sword.
   * @param sword the item that attack unit
   */
  void receiveSwordAttack(IEquipableItem sword);

  /**
   * Lets the Unit be attacked by an anima.
   * @param anima the item that attack unit
   */
  void receiveAnimaAttack(IEquipableItem anima);

  /**
   * Lets the Unit be attacked by an luz.
   * @param luz the item that attack unit
   */
  void receiveLuzAttack(IEquipableItem luz);

  /**
   * Lets the Unit be attacked by an oscuridad.
   * @param oscuridad the item that attack unit
   */
  void receiveOscuridadAttack(IEquipableItem oscuridad);

  /**
   * Lets the Unit be contra attacked by an axe.
   * @param axe the item that attack unit
   */
  void receiveAxeContraAttack(IEquipableItem axe);

  /**
   * Lets the Unit be contra attacked by an bow.
   * @param bow the item that attack unit
   */
  void receiveBowContraAttack(IEquipableItem bow);

  /**
   * Lets the Unit be contra attacked by an spear.
   * @param spear the item that attack unit
   */
  void receiveSpearContraAttack(IEquipableItem spear);

  /**
   * Lets the Unit be contra attacked by an sword.
   * @param sword the item that attack unit
   */
  void receiveSwordContraAttack(IEquipableItem sword);

  /**
   * Lets the Unit be contra attacked by an anima.
   * @param anima the item that attack unit
   */
  void receiveAnimaContraAttack(IEquipableItem anima);

  /**
   * Lets the Unit be contra attacked by an luz.
   * @param luz the item that attack unit
   */
  void receiveLuzContraAttack(IEquipableItem luz);

  /**
   * Lets the Unit be contra attacked by an oscuridad.
   * @param oscuridad the item that attack unit
   */
  void receiveOscuridadContraAttack(IEquipableItem oscuridad);

  /**
   * Lets the Unit receive an strengthened attack that hits his base damage * 1.5.
   * @param item the item that the unit receives attack.
   */
  void receiveStrengthenedAttack(IEquipableItem item);

  /**
   * Lets the Unit receive an weakened attack that hits his base damage minus 20. If the attack has a
   * base damage lower than 20, the unit currentHitPoints is not changed.
   * @param item the item that the unit receives attack.
   */
  void receiveWeakenedAttack(IEquipableItem item);

  /**
   * Lets the Unit heal.
   * @param item the unit that healing.
   */
  void receiveHeal(IEquipableItem item);

  /**
   * Check if the item is there.
   * @param item the item that is being looked for.
   * @return a boolean if the item is there.
   */
  boolean estaItem(IEquipableItem item);

  /**
   * Check if there is any space left in the list.
   * @return a boolean if there ani space in the list. False is full.
   */
  boolean hayEspacio();

  /**
   * Add Item to the list of items.
   * @param item the item to add.
   */
  void addItem(IEquipableItem item);

  /**
   * Delete Item to the list of items.
   * @param item the item to delete. If the item is not in list, it don't delete
   */
  void deleteItem(IEquipableItem item);

  /**
   * Give an item to the unit.
   * @param unit the unit that receive the item.
   * @param item the item that give to the unit
   */
  void darItem(IUnit unit, IEquipableItem item);

  /**
   * Performs the correct heal to the target Unit.
   * @param unit the target unit.
   */
  void heal(IUnit unit);

  /**
   * Equipa item nulo
   *
   * @param nItem
   *    item nulo a equipar
   */
  void equipNull(NullItem nItem);

}
