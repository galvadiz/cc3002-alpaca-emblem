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
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected List<IEquipableItem> items = new ArrayList<>();
  private int hitPointsMax;
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
  protected AbstractUnit(int hitPoints, int movement, Location location, int maxItems, IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.hitPointsMax = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipItem(IEquipableItem item) {
    //item.setOwner(this);
    for (IEquipableItem i: this.getItems()){
      if(item.equals(i)){
        item.equipTo(this);
        return;
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Location getLocation() {
    return location;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getMovement() {
    return movement;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipAxe(Axe axe){
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipBow(Bow bow){
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipSpear(Spear spear){
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipStaff(Staff staff){
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipSword(Sword sword){
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void equipMagia(IMagia magia){
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isAlive(){ return this.currentHitPoints > 0; }

  /**
   * {@inheritDoc}
   *
   *  attack if there is an equippedItem, the distance is in range and is alive.
   */
  @Override
  public void attack(IUnit unit){
    if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
            && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange() && isAlive()){
      equippedItem.attackTo(unit);
    }
  }

  /**
   * {@inheritDoc}
   *
   *  contra attack if there is an equippedItem, the distance is in range and is alive.
   */
  @Override
  public void contraAttack(IUnit unit){
    if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
          && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange() && isAlive()){
      equippedItem.contraAttackTo(unit);
    }
  }

  /**
   * {@inheritDoc}
   *
   * receive axe attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveAxeAttack(IEquipableItem axe){
    if(equippedItem != null){
      equippedItem.receiveAxeAttackItem(axe);

      contraAttack(axe.getOwner());

      return;
    }
    this.receiveAttack(axe); }

  /**
   * {@inheritDoc}
   *
   * receive bow attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveBowAttack(IEquipableItem bow){
    if (equippedItem != null){
      equippedItem.receiveBowAttackItem(bow);
      contraAttack(bow.getOwner());
      return;
    }
    this.receiveAttack(bow);
  }

  /**
   * {@inheritDoc}
   *
   * receive sword attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveSwordAttack(IEquipableItem sword){
    if(equippedItem != null){
      equippedItem.receiveSwordAttackItem(sword);
      contraAttack(sword.getOwner());
      return;
    }
    this.receiveAttack(sword);
  }

  /**
   * {@inheritDoc}
   *
   * receive spear attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveSpearAttack(IEquipableItem spear){
    if(equippedItem != null){
      equippedItem.receiveSpearAttackItem(spear);
      contraAttack(spear.getOwner());
      return;
    }
    this.receiveAttack(spear);
  }

  /**
   * {@inheritDoc}
   *
   * receive anima attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveAnimaAttack(IEquipableItem anima){
    if(equippedItem != null){
      equippedItem.receiveAnimaAttackItem(anima);
      contraAttack(anima.getOwner());
      return;
    }
    this.receiveAttack(anima); }

  /**
   * {@inheritDoc}
   *
   * receive luz attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveLuzAttack(IEquipableItem luz){
    if(equippedItem != null){
      equippedItem.receiveLuzAttackItem(luz);
      contraAttack(luz.getOwner());
      return;
    }
    this.receiveAttack(luz); }

  /**
   * {@inheritDoc}
   *
   * receive oscuridad attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveOscuridadAttack(IEquipableItem oscuridad){
    if(equippedItem != null){
      equippedItem.receiveOscuridadAttackItem(oscuridad);
      contraAttack(oscuridad.getOwner());
      return;
    }
    this.receiveAttack(oscuridad); }


  /**
   * {@inheritDoc}
   *
   * receive axe contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveAxeContraAttack(IEquipableItem axe){
    if(equippedItem != null){
      equippedItem.receiveAxeContraAttackItem(axe);
      return;
    }
    this.receiveAttack(axe); }

  /**
   * {@inheritDoc}
   *
   * receive bow contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveBowContraAttack(IEquipableItem bow){
    if (equippedItem != null){
      equippedItem.receiveBowContraAttackItem(bow);
      return;
    }
    this.receiveAttack(bow);
  }

  /**
   * {@inheritDoc}
   *
   * receive sword contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveSwordContraAttack(IEquipableItem sword){
    if(equippedItem != null){
      equippedItem.receiveSwordContraAttackItem(sword);
      return;
    }
    this.receiveAttack(sword);
  }

  /**
   * {@inheritDoc}
   *
   * receive spear contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveSpearContraAttack(IEquipableItem spear){
    if(equippedItem != null){
      equippedItem.receiveSpearContraAttackItem(spear);
      return;
    }
    this.receiveAttack(spear);
  }

  /**
   * {@inheritDoc}
   *
   * receive anima contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveAnimaContraAttack(IEquipableItem anima){
    if(equippedItem != null){
      equippedItem.receiveAnimaContraAttackItem(anima);
      return;
    }
    this.receiveAttack(anima); }

  /**
   * {@inheritDoc}
   *
   * receive luz contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveLuzContraAttack(IEquipableItem luz){
    if(equippedItem != null){
      equippedItem.receiveLuzContraAttackItem(luz);
      return;
    }
    this.receiveAttack(luz); }

  /**
   * {@inheritDoc}
   *
   * receive oscuridad contra attack if there is an equippedItem. if there isn't and equippedItem, receive base attack.
   */
  @Override
  public void receiveOscuridadContraAttack(IEquipableItem oscuridad){
    if(equippedItem != null){
      equippedItem.receiveOscuridadContraAttackItem(oscuridad);
      return;
    }
    this.receiveAttack(oscuridad); }


  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void receiveStrengthenedAttack(IEquipableItem item){
    currentHitPoints -= (item.getPower()*1.5);
    if(!isAlive()){
      currentHitPoints = 0;
    }
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void receiveWeakenedAttack(IEquipableItem item){
    int aux = item.getPower()-20;
    if (aux > 0) currentHitPoints -= (item.getPower()-20);
    if(!isAlive()){
      currentHitPoints = 0;
    }
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void receiveAttack(IEquipableItem item){
    currentHitPoints -= item.getPower();
    if(!isAlive()){
      currentHitPoints = 0;
    }
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void receiveHeal(IUnit unit){
    if (this.hitPointsMax - this.currentHitPoints < unit.getEquippedItem().getPower()){
      this.currentHitPoints = this.hitPointsMax;
      return;
    }
    this.currentHitPoints += unit.getEquippedItem().getPower();
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public boolean estaItem(IEquipableItem item){
    for (IEquipableItem i: items){
      if (item.equals(i)){
        return true;
      }
    }
    return false;
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void addItem(IEquipableItem item){
    if (hayEspacio()){
      items.add(item);
    }
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void deleteItem(IEquipableItem item){
    if (estaItem(item)){
      items.remove(item);
    }

  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void darItem(IUnit unit, IEquipableItem item){
    if(unit.hayEspacio() && getLocation().distanceTo(unit.getLocation()) == 1 && this.estaItem(item)){
      unit.addItem(item);
      this.deleteItem(item);
    }
  }

  /**
   * {@inheritDoc}
   *
   */
  @Override
  public boolean hayEspacio(){
    return items.size() < 3;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void heal(IUnit unit){
    //vacio ya que solo cura el cleric con staff equipado.
  }

}
