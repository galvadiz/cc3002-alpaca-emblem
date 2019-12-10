package model.items;

import model.units.IUnit;

public class NullItem extends AbstractItem {
    public NullItem() {
        super("", 0, 1, Integer.MAX_VALUE);
    }

    public void equipTo(IUnit unit){
        super.setOwner(unit);
        unit.equipNull(this);
    }
    public void useItem(IUnit unit){

    }

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
