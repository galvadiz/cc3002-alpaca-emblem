package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractMagia extends AbstractItem implements IMagia {

    private String name;
    private int power;
    protected int maxRange;
    protected int minRange;

    /**
     * Constructor for a default item Magia.
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
    public AbstractMagia(String name, int power, int minRange, int maxRange){
        super(name, power, minRange, maxRange);
    }
    @Override
    public void equipTo(IUnit unit){
        super.setOwner(unit);
        unit.equipMagia(this);
    }

}
