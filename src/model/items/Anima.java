package model.items;

import model.units.*;

/**
 * This class represents an Anima.
 * <p>
 * Anima are strong against luz and normal items but weak agains oscuridad.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public class Anima extends AbstractMagia {

    /**
     * Creates a new Anima item
     *
     * @param name
     *     the name of the Anima
     * @param power
     *     the damage of the Anima
     * @param minRange
     *     the minimum range of the Anima
     * @param maxRange
     *     the maximum range of the Anima
     */
    public Anima(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Anima)) return false;
        Anima that = (Anima) o;
        return this.getPower() == that.getPower() &&
                this.getMinRange() == that.getMinRange() &&
                this.getMaxRange() == that.getMaxRange() &&
                getName().equals(that.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackTo(IUnit unit){
        unit.receiveAnimaAttack(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void contraAttackTo(IUnit unit){
        unit.receiveAnimaContraAttack(this);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveOscuridadAttackItem(IEquipableItem anima){
        getOwner().receiveStrengthenedAttack(anima);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveOscuridadContraAttackItem(IEquipableItem anima){
        getOwner().receiveStrengthenedAttack(anima);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveLuzAttackItem(IEquipableItem oscuridad){
        getOwner().receiveWeakenedAttack(oscuridad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveLuzContraAttackItem(IEquipableItem oscuridad){
        getOwner().receiveWeakenedAttack(oscuridad);
    }

}
