package factory;

import model.items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactoryItems implements IFactoryItems {


    public FactoryItems(){

    }


    @Override
    public Anima createAnima() {
        return new Anima("Anima", 20, 1, 3);
    }

    @Override
    public Axe createAxe() {
        return new Axe("Axe", 30, 1, 2);
    }

    @Override
    public Bow createBow() {
        return new Bow("Bow", 15, 2, 4);
    }

    @Override
    public Luz createLuz() {
        return new Luz("Luz", 20, 1, 2);
    }

    @Override
    public Oscuridad createOscuridad() {
        return new Oscuridad("Oscuridad", 20, 1, 2);
    }

    @Override
    public Spear createSpear() {
        return new Spear("Separ", 25, 1, 3);
    }

    @Override
    public Staff createStaff() {
        return new Staff("Staff", 10, 1, 2);
    }

    @Override
    public Sword createSword() {
        return new Sword("Sword", 40, 1, 2);
    }
}
