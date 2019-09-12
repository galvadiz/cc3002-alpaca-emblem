package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IMagia extends IEquipableItem {

    /**
     * Equips this item to a unit.
     *
     * @param unit
     *     the unit that will be quipped with the item
     */
    @Override
    void equipTo(IUnit unit);

}
