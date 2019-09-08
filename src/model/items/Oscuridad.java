package model.items;

import model.units.*;

/**
 * This class represents an Oscuridad.
 * <p>
 * Axes are strong against spears but weak agains swords.
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

}
