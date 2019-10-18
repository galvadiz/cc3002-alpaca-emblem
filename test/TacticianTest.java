import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class TacticianTest {

    private String expectedName;
    private Tactician tactician1;

    @BeforeEach
    public void setUp() {
        setTestTactician();
    }

    public void setTestTactician(){
        expectedName = "GeraJera";
        tactician1 = new Tactician(expectedName);
    }

    @Test
    public void constructorTest(){
        assertEquals(expectedName, tactician1.getName());
        assertEquals(0, tactician1.getUnits().size());
        assertNull(tactician1.getUnitSelection());
        tactician1.setUnitSelection(new Archer(100, 2, new Location(2, 1)));
        assertNull(tactician1.getUnitSelection());
    }


}
