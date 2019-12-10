package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {

  private int numberOfPlayers = 0;
  private int mapSize = 0;
  private List<Tactician> tacticians = new ArrayList<>();
  private Tactician actualTactician;
  private int round_number = 0;
  private int jugadoresQueHanTerminadoTurno = 0;
  private int max_rounds = 0;
  private IUnit unitSeleccionadaEnMapa;
  private IEquipableItem itemUnitSeleccionada;
  private Field gameMap;
  private long randomSeed = new Random().nextLong();

  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
    this.numberOfPlayers = numberOfPlayers;
    this.mapSize = mapSize;
    this.gameMap = new Field();
    for(int i = 0; i < mapSize; i++){
      for(int j = 0; j < mapSize; j++){
        gameMap.addCells(false, new Location(i,j));

      }
    }
  }

  public void setTacticians(List<String> nombresJugadores){
    tacticians.clear();
    for (String s: nombresJugadores){
      tacticians.add(new Tactician(s));
    }
  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticians() {
    return tacticians;
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return gameMap;
  }

  /**
   * @return seed of the current game
   */
  public long getSeed(){
    return randomSeed;
  }
  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return actualTactician;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return round_number;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return max_rounds;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {
    jugadoresQueHanTerminadoTurno++;
    if (jugadoresQueHanTerminadoTurno == numberOfPlayers){
      round_number++;
      jugadoresQueHanTerminadoTurno = 0;
    }
  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {
    for (Tactician t: tacticians){
      if(t.getName().equals(tactician)){
        tacticians.remove(t);
        numberOfPlayers--;
        return;
      }
    }

  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(int maxTurns) {
    max_rounds = maxTurns;
    round_number = 1;
  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {
    max_rounds = -1;
    round_number = 1;
  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    List<String> winners = new ArrayList<>();
    if (seAcaboJuego()) {
      int mayorActual = 0;
      List<Integer> mayores = new ArrayList<>();
      mayores.add(mayorActual);
      for (int i = 1; i < tacticians.size(); i++) {
        if (tacticians.get(i).getUnits().size() > tacticians.get(mayorActual).getUnits().size()){
          mayorActual = i;
          mayores.clear();
          mayores.add(i);
        }
        else if (tacticians.get(i).getUnits().size() == tacticians.get(mayorActual).getUnits().size()){
          mayorActual = i;
          mayores.add(i);
        }
      }
      for (Integer index: mayores){
        winners.add(tacticians.get(index).getName());
      }
    }
    else{
      winners = null;
    }
    return winners;
  }

  public boolean seAcaboJuego(){
    return round_number == max_rounds + 1 || tacticians.size() == 1;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return actualTactician.getUnitSelection();
  }

  public void setTurnOwner(Tactician tactician) {
    actualTactician = tactician;
  }

  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {
    for (Tactician t: tacticians){
      for (IUnit u: t.getUnits()){
        Location l = u.getLocation();
        if (l.getRow() == x && l.getColumn() == y){
          unitSeleccionadaEnMapa = u;
        }

      }
    }

  }

  public IUnit getSelectUnitIn(){
    return unitSeleccionadaEnMapa;
  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return this.getSelectedUnit().getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
    this.getSelectedUnit().equipItem(this.getItems().get(index));
  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {
    selectUnitIn(x, y);
    this.getSelectedUnit().getEquippedItem().useItem(unitSeleccionadaEnMapa);
  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {
    itemUnitSeleccionada = this.getSelectedUnit().getItems().get(index);
  }

  public IEquipableItem getSelectItem(){
    return itemUnitSeleccionada;
  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {
    selectUnitIn(x, y);
    this.getSelectedUnit().darItem(unitSeleccionadaEnMapa, itemUnitSeleccionada);
  }
}
