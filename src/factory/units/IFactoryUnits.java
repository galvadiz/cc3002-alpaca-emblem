package factory.units;

import model.units.*;

public interface IFactoryUnits {

    /**
     * @return nueva unidad del tipo Archer
     */
    Archer createArcher();

    /**
     * @return nueva unidad del tipo Alpaca
     */
    Alpaca createAlpaca();

    /**
     * @return nueva unidad del tipo Cleric
     */
    Cleric createCleric();

    /**
     * @return nueva unidad del tipo Fighter
     */
    Fighter createFighter();

    /**
     * @return nueva unidad del tipo Hero
     */
    Hero createHero();

    /**
     * @return nueva unidad del tipo Sorcerer
     */
    Sorcerer createSorcerer();

    /**
     * @return nueva unidad del tipo SwordMaster
     */
    SwordMaster createSwordMaster();

}
