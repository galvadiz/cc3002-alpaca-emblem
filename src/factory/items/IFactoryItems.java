package factory.items;

import model.items.*;
import model.units.IUnit;

import java.io.ObjectStreamClass;

public interface IFactoryItems {

    /**
     * @return nuevo Item del tipo Anima
     */
    Anima createAnima();

    /**
     * @return nuevo Item del tipo Axe
     */
    Axe createAxe();

    /**
     * @return nuevo Item del tipo Bow
     */
    Bow createBow();

    /**
     * @return nuevo Item del tipo Luz
     */
    Luz createLuz();

    /**
     * @return nuevo Item del tipo Oscuridad
     */
    Oscuridad createOscuridad();

    /**
     * @return nuevo Item del tipo Spear
     */
    Spear createSpear();

    /**
     * @return nuevo Item del tipo Staff
     */
    Staff createStaff();

    /**
     * @return nuevo Item del tipo Sword
     */
    Sword createSword();




    /*IUnit createArcher();
    IUnit createAlpaca();
    IUnit createCleric();
    IUnit createFighter();
    IUnit createHero();
    IUnit createSorcerer();
    IUnit createSwordMaster();*/
}
