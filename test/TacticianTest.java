import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import model.units.*;
import model.Tactician;
import model.map.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Tactician
 *
 * @author Geraldine Alvadiz Drez
 * @since 1.0
 */
public class TacticianTest {

    private String expectedName;
    private Tactician tactician1;
    private Field field;

    @BeforeEach
    public void setUp() {
        setTestTactician();
        setField();
    }

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    public void setTestTactician(){
        expectedName = "GeraJera";
        tactician1 = new Tactician(expectedName);
    }

    /**
     * Set up the game field
     */
    public void setField() {
        this.field = new Field();
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Location actualLocation = new Location (i, j);
                actualLocation.setUnit(new NullUnit(actualLocation));
                this.field.addCells(true, actualLocation);

            }
        }
    }

    /**
     * Checks that the constructor works properly.
     */
    @Test
    public void constructorTest(){
        assertEquals(expectedName, tactician1.getName());
        assertEquals(1, tactician1.getUnits().size());
        assertEquals(new NullUnit(new InvalidLocation()),tactician1.getUnitSelection());
        tactician1.setUnitSelection(new Archer(100, 2, field.getCell(2, 1)));
        assertEquals(new NullUnit(new InvalidLocation()),tactician1.getUnitSelection());
    }
    @Test
    public void moveUnitSelectionTest(){
        assertEquals(expectedName, tactician1.getName());
        assertEquals(1, tactician1.getUnits().size());
        assertEquals(new NullUnit(new InvalidLocation()),tactician1.getUnitSelection());
        Archer archer = new Archer(100, 2, field.getCell(2, 1));
        tactician1.setUnitSelection(archer);
        assertEquals(new NullUnit(new InvalidLocation()),tactician1.getUnitSelection());

        List<IUnit> units = new ArrayList<>();
        units.add(archer);
        tactician1.setUnits(units);
        tactician1.setUnitSelection(archer);
        assertEquals(archer, tactician1.getUnitSelection());

        assertEquals(2, tactician1.getUnitSelection().getLocation().getRow());
        assertEquals(1, tactician1.getUnitSelection().getLocation().getColumn());
        tactician1.moveUnitSelection(field.getCell(1, 1));
        assertEquals(1, tactician1.getUnitSelection().getLocation().getRow());
        assertEquals(1, tactician1.getUnitSelection().getLocation().getColumn());

    }


}
