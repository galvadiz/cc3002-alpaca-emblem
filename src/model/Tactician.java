package model;

import controller.DeadHeroUnitTacticianHandler;
import controller.EndTurnHandler;
import factory.units.FactoryUnits;
import model.map.Field;
import model.map.InvalidLocation;
import model.map.Location;
import model.units.Hero;
import model.units.IUnit;
import model.units.NullUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Tacticians
 * Los tacticians son los que representan al usuario en el juego
 * (el usuario se comunica con el controller y el controller con los TacticianS)
 *
 * @author Geraldine Alvadiz
 * @version 2.0
 * @since 2.0
 */
public class Tactician {

    private  String name;
    private List<IUnit> units = new ArrayList<>();
    private List<IUnit> unitsMovidas = new ArrayList<>();
    private IUnit unitSelection = new NullUnit(new InvalidLocation());
    private PropertyChangeSupport
            endTurn = new PropertyChangeSupport(this),
            deadHero = new PropertyChangeSupport(this);
    private Field gameMap;
    private DeadHeroUnitTacticianHandler deadHeroUnitTacticianHandler = new DeadHeroUnitTacticianHandler(this);

    /**
     * Creates a new Tactician
     * @param name
     *      nombre del nuevo Tactician
     *
     */
    public Tactician(String name) {
        this.name = name;
        FactoryUnits f = new FactoryUnits();
        Hero hero = f.createHero();
        units.add(hero);
        hero.getDeadHero().addPropertyChangeListener(deadHeroUnitTacticianHandler);
    }

    /**
     *
     * @return nombre del Tactician
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return lista de las unidades del Tactician
     */
    public List<IUnit> getUnits(){
        return units;
    }

    /**
     *
     * @return unidad seleccionada por el Tactician
     */
    public IUnit getUnitSelection(){
        return unitSelection;
    }

    /**
     * Settea la unidad actual seleccioanda por el Tactician
     *
     * @param unit
     *      unidad seleccionada por el Tactician
     */
    public void setUnitSelection(IUnit unit){
        for (IUnit u: units){
            if (u.equals(unit)){
                unitSelection = unit;
            }
        }

    }

    public void setGameMap(Field field){
        this.gameMap = field;
    }

    /**
     * Settea la lista de unidades del Tactician
     *
     * @param units
     *      lista de unidades del Tactician
     */
    public void setUnits(List<IUnit> units){
        this.units = units;
    }

    /**
     * Mueve la unidad seleccionada a location si no está ocupada.
     *
     * @param location
     *      location donde será movida la unidad seleccionada
     */
    public void moveUnitSelection(Location location){
        if (!unitsMovidas.contains(unitSelection)) {
            unitSelection.moveTo(location);
            unitsMovidas.add(unitSelection);
        }
    }

    /**
     * Termina el turno del Tactician vaciando la lista de unidades movidas
     */
    public void endTurn(){
        endTurn.firePropertyChange(new PropertyChangeEvent(this, "end turn", "", this.name));
        unitsMovidas.clear();

    }

    /**
     *
     * @return propertyChangeSuport de termino de turno para poder utilizarlo fuera de la clase.
     */
    public PropertyChangeSupport getEndTurn(){
        return endTurn;
    }

    /**
     * Avisa a GC que el heroe murio
     */
    public void deadHero(){
        deadHero.firePropertyChange(new PropertyChangeEvent(this, this.name, "vivo", "muerto"));
    }

    /**
     *
     * @return propertyChangeSuport de muerte de heroe para poder utilizarlo fuera de la clase.
     */
    public PropertyChangeSupport getDeadHero(){
        return deadHero;
    }
}
