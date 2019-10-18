package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public abstract class AbstractItemNoAttack extends AbstractItem implements IEquipableItemNoAttack {


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
  public AbstractItemNoAttack(String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract void equipTo(IUnit unit);


  /**
   * {@inheritDoc}
   *
   * @param o The target item object
   * @return True if are equals, false otherwise
   */
  @Override
  public abstract boolean equals(Object o);
}
