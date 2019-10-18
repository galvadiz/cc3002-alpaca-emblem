package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all magic items.
 *
 * @author Geraldine Alvadiz
 * @since 1.0
 */
public abstract class AbstractMagia extends AbstractItemAttack implements IMagia {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveAxeAttackItem(IEquipableItem axe){
        getOwner().receiveStrengthenedAttack(axe);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveBowAttackItem(IEquipableItem bow){
        getOwner().receiveStrengthenedAttack(bow);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveSpearAttackItem(IEquipableItem spear){
        getOwner().receiveStrengthenedAttack(spear);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveSwordAttackItem(IEquipableItem sword){
        getOwner().receiveStrengthenedAttack(sword);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveAxeContraAttackItem(IEquipableItem axe){
        getOwner().receiveStrengthenedAttack(axe);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveBowContraAttackItem(IEquipableItem bow){
        getOwner().receiveStrengthenedAttack(bow);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveSpearContraAttackItem(IEquipableItem spear){
        getOwner().receiveStrengthenedAttack(spear);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveSwordContraAttackItem(IEquipableItem sword){
        getOwner().receiveStrengthenedAttack(sword);
    }

}
