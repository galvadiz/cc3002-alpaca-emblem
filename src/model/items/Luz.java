package model.items;

import model.units.*;

/**
 * This class represents an Luz.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Luz extends AbstractMagia {

    /**
     * Creates a new Luz item
     *
     * @param name
     *     the name of the Luz
     * @param power
     *     the damage of the Luz
     * @param minRange
     *     the minimum range of the Luz
     * @param maxRange
     *     the maximum range of the Luz
     */
    public Luz(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Luz)) return false;
        Luz that = (Luz) o;
        return this.getPower() == that.getPower() &&
                this.getMinRange() == that.getMinRange() &&
                this.getMaxRange() == that.getMaxRange() &&
                getName().equals(that.getName());
    }

    @Override
    public void attackTo(IUnit unit){
        unit.receiveLuzAttack(this);
    }

    @Override
    public void receiveAnimaAttackItem(IEquipableItem anima){
        getOwner().receiveStrengthenedAttack(anima);
    }

    @Override
    public void receiveOscuridadAttackItem(IEquipableItem oscuridad){
        getOwner().receiveWeakenedAttack(oscuridad);
    }

}
