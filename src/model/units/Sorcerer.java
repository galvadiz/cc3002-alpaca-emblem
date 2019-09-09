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
     * Creates a new archer
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

    public void equipMagia(IMagia magia){
        equippedItem = magia;
    }

    public void attack(IUnit unit){
        if(equippedItem != null && this.getLocation().distanceTo(unit.getLocation()) >= equippedItem.getMinRange()
                && this.getLocation().distanceTo(unit.getLocation()) <= equippedItem.getMaxRange()){

            equippedItem.attackTo(unit);
        }
    }

    @Override
    public void receiveMagicAttack(IEquipableItem magia){
        if (equippedItem != null){
            equippedItem.attackTo(this);
        }
        super.receiveMagicAttack(magia);
    }

    @Override
    public void receiveAnimaAttack(IEquipableItem anima){
        if(equippedItem != null){
            equippedItem.receiveAnimaAttackItem(anima);
            return;
        }
        super.receiveAnimaAttack(anima); }

    @Override
    public void receiveLuzAttack(IEquipableItem luz){
        if(equippedItem != null){
            equippedItem.receiveLuzAttackItem(luz);
            return;
        }
        super.receiveLuzAttack(luz); }

    @Override
    public void receiveOscuridadAttack(IEquipableItem oscuridad){
        if(equippedItem != null){
            equippedItem.receiveOscuridadAttackItem(oscuridad);
            return;
        }
        super.receiveOscuridadAttack(oscuridad); }
}

