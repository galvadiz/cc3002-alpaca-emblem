package model.units;

import model.items.NullItem;
import model.map.Location;

public class NullUnit extends AbstractUnit{

    /**
     * Creates a new Unit.
     *
     * @param location  the current position of this unit on the map
     */
    public NullUnit(Location location) {
        super(0, 0, location, 1, new NullItem());
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof NullUnit)) return false;
        NullUnit that = (NullUnit) o;
        return this.getCurrentHitPoints() == that.getCurrentHitPoints() &&
                this.getMovement() == that.getMovement() &&
                this.getHitPointsMax() == that.getHitPointsMax() &&
                //getLocation().getColumn() == that.getLocation().getColumn() &&
                //getLocation().getRow() == that.getLocation().getRow() &&
                getEquippedItem().equals(that.getEquippedItem()) &&
                getItems().equals(that.getItems());
    }
}
