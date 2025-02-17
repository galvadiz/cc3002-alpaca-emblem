package model.units;

import model.items.*;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an <i>Sorcerer</i> type unit.
 * <p>
 * This kind of unit <b>can only use bows</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sorcerer extends AbstractUnit {

    /**
     * Creates a new sorcerer
     *
     * @param hitPoints
     *     maximum hit points of the unit
     * @param movement
     *     the amount of cells this unit can move
     * @param position
     *     the initial position of this unit
     * @param items
     *     the items carried by this unit
     */
    public Sorcerer(int hitPoints, int movement, Location position, IEquipableItem... items) {
        super(hitPoints, movement, position, 3, items);
    }

    /**
     * {@inheritDoc}
     *
     * sorcerer only can equip magia
     */
    @Override
    public void equipMagia(IMagia magia){
        equippedItem = magia;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Sorcerer)) return false;
        Sorcerer that = (Sorcerer) o;
        return this.getCurrentHitPoints() == that.getCurrentHitPoints() &&
                this.getMovement() == that.getMovement() &&
                this.getHitPointsMax() == that.getHitPointsMax() &&
                //getLocation().getColumn() == that.getLocation().getColumn() &&
                //getLocation().getRow() == that.getLocation().getRow() &&
                getEquippedItem().equals(that.getEquippedItem()) &&
                getItems().equals(that.getItems());
    }

}

