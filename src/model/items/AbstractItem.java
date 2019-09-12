package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(String name, int power, int minRange, int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public void equipTo(IUnit unit) {

  }

  @Override
  public void setOwner(IUnit unit) {
    owner = unit;
  }

  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

  @Override
  public void attackTo(IUnit unit){

  }

  public void contraAttackTo(IUnit unit){

  }

  public void receiveAnimaAttackItem(IEquipableItem item) {
    getOwner().receiveAttack(item);
  }

  public void receiveLuzAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveOscuridadAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveAxeAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveBowAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveSpearAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveSwordAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveAnimaContraAttackItem(IEquipableItem item) {
    getOwner().receiveAttack(item);
  }

  public void receiveLuzContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveOscuridadContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveAxeContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveBowContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveSpearContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  public void receiveSwordContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  @Override
  public abstract boolean equals(Object o);
}
