package model;

import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

    private  String name;
    private List<IUnit> units = new ArrayList<>();
    private List<IUnit> unitsMovidas = new ArrayList<>();
    private IUnit unitSelection;
    private PropertyChangeSupport finTurno = new PropertyChangeSupport(this);


    /**
     * Creates a new Tactician
     * @param name
     *      nombre del nuevo Tactician
     *
     */
    public Tactician(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<IUnit> getUnits(){
        return units;
    }

    public IUnit getUnitSelection(){
        return unitSelection;
    }

    public void setUnitSelection(IUnit unit){
        for (IUnit u: units){
            if (u.equals(unit)){
                unitSelection = unit;
            }
        }

    }
    public void setUnits(List<IUnit> units){
        this.units = units;
    }

    public void moveUnitSelection(Location location){
        if (!unitsMovidas.contains(unitSelection)) {
            unitSelection.moveTo(location);
            unitsMovidas.add(unitSelection);
        }
    }

    public void endTurn(){
        unitsMovidas.clear();

    }


}
