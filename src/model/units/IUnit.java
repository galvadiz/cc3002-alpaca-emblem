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
 * @author Ignacio Slater Muñoz
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
  void equipMagia(Magia magia);

  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

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


  void attack(IUnit unit);

  void receiveAxeAttack(IEquipableItem axe);

  void receiveBowAttack(IEquipableItem bow);

  void receiveSpearAttack(IEquipableItem spear);

  void receiveSwordAttack(IEquipableItem sword);

  void receiveAnimaAttack(IEquipableItem anima);

  void receiveLuzAttack(IEquipableItem luz);

  void receiveOscuridadAttack(IEquipableItem oscuridad);

  void receiveStrengthenedAttack(IEquipableItem item);

  void receiveWeakenedAttack(IEquipableItem item);

}
