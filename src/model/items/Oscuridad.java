package model.items;

import model.units.*;

/**
 * This class represents an Oscuridad.
 * <p>
 * Oscuridad are strong against anima and normal items but weak agains luz.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Oscuridad extends AbstractMagia {

    /**
     * Creates a new Oscuridad item
     *
     * @param name
     *     the name of the Oscuridad
     * @param power
     *     the damage of the Oscuridad
     * @param minRange
     *     the minimum range of the Oscuridad
     * @param maxRange
     *     the maximum range of the Oscuridad
     */
    public Oscuridad(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Oscuridad)) return false;
        Oscuridad that = (Oscuridad) o;
        return this.getPower() == that.getPower() &&
                this.getMinRange() == that.getMinRange() &&
                this.getMaxRange() == that.getMaxRange() &&
                getName().equals(that.getName());
    }

    /**
     * {@inheritDoc}
     *
     * attack the unit with oscuridad.
     */
    @Override
    public void attackTo(IUnit unit){
        unit.receiveOscuridadAttack(this);
    }

    /**
     * {@inheritDoc}
     *
     * contra attack the unit with oscuridad.
     */
    @Override
    public void contraAttackTo(IUnit unit){
        unit.receiveOscuridadContraAttack(this);
    }

    /**
     * {@inheritDoc}
     *
     * receive strengthened attack from luz.
     */
    @Override
    public void receiveLuzAttackItem(IEquipableItem luz){
        getOwner().receiveStrengthenedAttack(luz);
    }

    /**
     * {@inheritDoc}
     *
     * receive weakened attack from anima.
     */
    @Override
    public void receiveAnimaAttackItem(IEquipableItem anima){
        getOwner().receiveWeakenedAttack(anima);
    }

    /**
     * {@inheritDoc}
     *
     * receive strengthened contra attack from luz.
     */
    @Override
    public void receiveLuzContraAttackItem(IEquipableItem luz){
        getOwner().receiveStrengthenedAttack(luz);
    }

    /**
     * {@inheritDoc}
     *
     * receive weakened contra attack from anima.
     */
    @Override
    public void receiveAnimaContraAttackItem(IEquipableItem anima){
        getOwner().receiveWeakenedAttack(anima);
    }

}
