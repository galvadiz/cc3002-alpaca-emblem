package factory.units;

import model.map.InvalidLocation;
import model.units.*;

public class FactoryUnits implements IFactoryUnits{

    @Override
    public Archer createArcher() {
        return new Archer(100, 2 ,new InvalidLocation());
    }

    @Override
    public Alpaca createAlpaca() {
        return new Alpaca(100, 3, new InvalidLocation());
    }

    @Override
    public Cleric createCleric() {
        return new Cleric(100, 4, new InvalidLocation());
    }

    @Override
    public Fighter createFighter() {
        return new Fighter(100, 5, new InvalidLocation());
    }

    @Override
    public Hero createHero() {
        return new Hero(100, 4, new InvalidLocation());
    }

    @Override
    public Sorcerer createSorcerer() {
        return new Sorcerer(100, 3, new InvalidLocation());
    }

    @Override
    public SwordMaster createSwordMaster() {
        return new SwordMaster(100, 2, new InvalidLocation());
    }
}
