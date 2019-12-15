package controller;

import model.Tactician;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeadHeroUnitTacticianHandler implements PropertyChangeListener {
    private Tactician tactician;

    /**
     * Creates a new handler for the end Turn of Tactician
     *
     * @param tactician
     *     The object to be notified of the change.
     */
    public DeadHeroUnitTacticianHandler(Tactician tactician){
        this.tactician = tactician;
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt
     *     A PropertyChangeEvent object describing the event source
     *     and the property that has changed.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        tactician.deadHero();
    }
}
