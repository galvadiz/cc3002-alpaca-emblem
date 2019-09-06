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
public class Luz extends Magia {

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

}
