package model.items;

import model.units.*;

/**
 * This class represents an Anima.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
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

}
