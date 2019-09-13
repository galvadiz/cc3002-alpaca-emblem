package model.items;

import model.units.*;


/**
 * This interface represents the <i>magic weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the magic weapons are defined here. Every magic weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Geraldine Alvadiz
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
