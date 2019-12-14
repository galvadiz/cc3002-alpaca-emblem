package factory.units;

import model.units.*;

public interface IFactoryUnits {

    Archer createArcher();
    Alpaca createAlpaca();
    Cleric createCleric();
    Fighter createFighter();
    Hero createHero();
    Sorcerer createSorcerer();
    SwordMaster createSwordMaster();

}
