package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EndTurnHandler implements PropertyChangeListener {
    private GameController controller;

    /**
     * Creates a new handler for the end Turn of Tactician
     *
     * @param controller
     *     The object to be notified of the change.
     */
    public EndTurnHandler(GameController controller){
        this.controller = controller;
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
        controller.endTurn();
    }
}
