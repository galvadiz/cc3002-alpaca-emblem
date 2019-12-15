package factory.items;

import model.items.*;

public class FactoryItems implements IFactoryItems {
    /**
     *{@inheritDoc}
     */
    @Override
    public Anima createAnima() {
        return new Anima("Anima", 20, 1, 3);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Axe createAxe() {
        return new Axe("Axe", 30, 1, 2);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Bow createBow() {
        return new Bow("Bow", 15, 2, 4);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Luz createLuz() {
        return new Luz("Luz", 20, 1, 2);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Oscuridad createOscuridad() {
        return new Oscuridad("Oscuridad", 20, 1, 2);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Spear createSpear() {
        return new Spear("Separ", 25, 1, 3);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Staff createStaff() {
        return new Staff("Staff", 10, 1, 2);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public Sword createSword() {
        return new Sword("Sword", 40, 1, 2);
    }
}
