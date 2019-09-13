package model.items;

import model.units.*;

/**
 * This class represents an Luz.
 * <p>
 * Luz are strong against oscuridad and normal items but weak agains anima.
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     *
     * attack the unit with luz
     */
    @Override
    public void attackTo(IUnit unit){
        unit.receiveLuzAttack(this);
    }

    /**
     * {@inheritDoc}
     *
     * contra attack the unit with luz
     */
    @Override
    public void contraAttackTo(IUnit unit){
        unit.receiveLuzContraAttack(this);
    }

    /**
     * {@inheritDoc}
     *
     * receive strengthened attack from anima
     */
    @Override
    public void receiveAnimaAttackItem(IEquipableItem anima){
        getOwner().receiveStrengthenedAttack(anima);
    }

    /**
     * {@inheritDoc}
     *
     * receive weakened attack from oscuridad
     */
    @Override
    public void receiveOscuridadAttackItem(IEquipableItem oscuridad){
        getOwner().receiveWeakenedAttack(oscuridad);
    }

    /**
     * {@inheritDoc}
     *
     * receive strengthened contra attack from anima
     */
    @Override
    public void receiveAnimaContraAttackItem(IEquipableItem anima){
        getOwner().receiveStrengthenedAttack(anima);
    }

    /**
     * {@inheritDoc}
     *
     * receive weakened contra attack from oscuridad
     */
    @Override
    public void receiveOscuridadContraAttackItem(IEquipableItem oscuridad){
        getOwner().receiveWeakenedAttack(oscuridad);
    }

}
