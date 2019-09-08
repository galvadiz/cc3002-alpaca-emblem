package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IMagia extends IEquipableItem {

    void equipTo(IUnit unit);

}
