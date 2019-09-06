package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.*;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected List<IEquipableItem> items = new ArrayList<>();
  private int currentHitPoints;
  private int movement;
  protected IEquipableItem equippedItem;
  private Location location;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void equipItem(IEquipableItem item) {
    //item.setOwner(this);
    item.equipTo(this);
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void equipAxe(Axe axe){
  }

  @Override
  public void equipBow(Bow bow){
  }

  @Override
  public void equipSpear(Spear spear){
  }

  @Override
  public void equipStaff(Staff staff){
  }

  @Override
  public void equipSword(Sword sword){
  }

  @Override
  public void equipMagia(Magia magia){
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  @Override
  public void attack(IUnit unit){

  }

  @Override
  public void receiveAxeAttack(IEquipableItem axe){
    currentHitPoints -= axe.getPower();
  }

  @Override
  public void receiveBowAttack(IEquipableItem bow){
    currentHitPoints -= bow.getPower();
  }

  @Override
  public void receiveSpearAttack(IEquipableItem spear){
    currentHitPoints -= spear.getPower();
  }

  @Override
  public void receiveSwordAttack(IEquipableItem sword){
    currentHitPoints -= sword.getPower();
  }

  @Override
  public void receiveAnimaAttack(IEquipableItem anima){
    currentHitPoints -= anima.getPower();
  }

  @Override
  public void receiveLuzAttack(IEquipableItem luz){
    currentHitPoints -= luz.getPower();
  }

  @Override
  public void receiveOscuridadAttack(IEquipableItem oscuridad){
    currentHitPoints -= oscuridad.getPower();
  }

  @Override
  public void receiveStrengthenedAttack(IEquipableItem item){
    currentHitPoints -= (item.getPower()*1.5);
  }

  @Override
  public void receiveWeakenedAttack(IEquipableItem item){
    currentHitPoints -= (item.getPower()-20);
  }

}
