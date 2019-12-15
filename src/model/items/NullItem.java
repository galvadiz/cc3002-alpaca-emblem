package model.items;

import model.units.IUnit;



/**
 * This class represents an Null Item.
 * <p>
 * Un item nulo no tiene nombre, no tiene power y tiene rango "infinito"
 *
 * @author Geraldine Alvadiz
 * @since 2.0
 */
public class NullItem extends AbstractItem {

/**
 * Creates a new NullItem
 */
public NullItem() {
        super("", 0, 1, Integer.MAX_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void equipTo(IUnit unit){
        super.setOwner(unit);
        unit.equipNull(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void useItem(IUnit unit){

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof NullItem)) return false;
        NullItem that = (NullItem) o;
        return this.getPower() == that.getPower() &&
                this.getMinRange() == that.getMinRange() &&
                this.getMaxRange() == that.getMaxRange() &&
                getName().equals(that.getName());
    }
}
