package model;

import model.units.IUnit;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

    private  String name;
    private List<IUnit> units = new ArrayList<>();
    private IUnit unit_selection;

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
        return unit_selection;
    }

    public void setUnitSelection(IUnit unit){
        unit_selection = unit;
    }


}
