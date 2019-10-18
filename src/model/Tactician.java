package model;

import model.units.IUnit;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

    private  String name;
    private List<IUnit> units = new ArrayList<>();
    private IUnit unitSelection;

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


}
