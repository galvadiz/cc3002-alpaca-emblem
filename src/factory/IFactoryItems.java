package factory;

import model.items.*;
import model.units.IUnit;

import java.io.ObjectStreamClass;

public interface IFactoryItems {
    Anima createAnima();
    Axe createAxe();
    Bow createBow();
    Luz createLuz();
    Oscuridad createOscuridad();
    Spear createSpear();
    Staff createStaff();
    Sword createSword();




    /*IUnit createArcher();
    IUnit createAlpaca();
    IUnit createCleric();
    IUnit createFighter();
    IUnit createHero();
    IUnit createSorcerer();
    IUnit createSwordMaster();*/
}
