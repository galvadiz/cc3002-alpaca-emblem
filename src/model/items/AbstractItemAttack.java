package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public abstract class AbstractItemAttack implements IEquipableItemAttack {

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

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract void equipTo(IUnit unit);

  /**
   * {@inheritDoc}
   */
  @Override
  public void setOwner(IUnit unit) {
    owner = unit;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IUnit getOwner() {
    return owner;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPower() {
    return power;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getMinRange() {
    return minRange;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getMaxRange() {
    return maxRange;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void attackTo(IUnit unit){

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void contraAttackTo(IUnit unit){

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveAnimaAttackItem(IEquipableItem item) {
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveLuzAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveOscuridadAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveAxeAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveBowAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveSpearAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveSwordAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveAnimaContraAttackItem(IEquipableItem item) {
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveLuzContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveOscuridadContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveAxeContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveBowContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveSpearContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void receiveSwordContraAttackItem(IEquipableItem item){
    getOwner().receiveAttack(item);
  }


  /**
   * {@inheritDoc}
   *
   * @param o The target item object
   * @return True if are equals, false otherwise
   */
  @Override
  public abstract boolean equals(Object o);
}
