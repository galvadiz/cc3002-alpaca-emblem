package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class OscuridadTest extends AbstractTestItem {

    private Oscuridad oscuridad;
    private Oscuridad wrongOscuridad;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Common oscuridad";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        oscuridad = new Oscuridad(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongOscuridad = new Oscuridad("Wrong oscuridad", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0), oscuridad);
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongOscuridad;
    }

    @Override
    public IEquipableItem getTestItem() {
        return oscuridad;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
