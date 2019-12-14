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
class LuzTest extends AbstractTestItem {

    private Luz luz;
    private Luz wrongLuz;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Common luz";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        luz = new Luz(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongLuz = new Luz("Wrong luz", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0), luz);
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongLuz;
    }

    @Override
    public IEquipableItem getTestItem() {
        return luz;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
