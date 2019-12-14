package factory;

import model.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryItemsTest {

    private Bow bow, bow2;
    private Axe axe, axe2;
    private Sword sword, sword2;
    private Staff staff, staff2;
    private Spear spear, spear2;
    private IMagia anima, anima2, luz, luz2, oscuridad, oscuridad2;
    private FactoryItems f;


    void setItems(){
        this.axe2 = new Axe("Axe", 30, 1, 2);
        this.sword2 = new Sword("Sword", 40, 1, 2);
        this.spear2 = new Spear("Separ", 25, 1, 3);
        this.staff2 = new Staff("Staff", 10, 1, 2);
        this.bow2 = new Bow("Bow", 15, 2, 4);
        this.anima2 = new Anima("Anima", 20, 1, 3);
        this.luz2 = new Luz("Luz", 20, 1, 2);
        this.oscuridad2 = new Oscuridad("Oscuridad", 20, 1, 2);
    }

    @BeforeEach
    void setUp(){
        f = new FactoryItems();
        setItems();
    }

    @Test
    void createAxe(){
        axe = f.createAxe();
        assertEquals(axe2, axe);
    }

    @Test
    void createBow(){
        bow = f.createBow();
        assertEquals(bow2, bow);
    }

    @Test
    void createSword(){
        sword = f.createSword();
        assertEquals(sword2, sword);
    }
    @Test
    void createStaff(){
        staff = f.createStaff();
        assertEquals(staff2, staff);
    }
    @Test
    void createSpear(){
        spear = f.createSpear();
        assertEquals(spear2, spear);
    }
    @Test
    void createAnima(){
        anima = f.createAnima();
        assertEquals(anima2, anima);
    }
    @Test
    void createLuz(){
        luz = f.createLuz();
        assertEquals(luz2, luz);
    }
    @Test
    void createOscuridad(){
        oscuridad = f.createOscuridad();
        assertEquals(oscuridad2, oscuridad);
    }


}
