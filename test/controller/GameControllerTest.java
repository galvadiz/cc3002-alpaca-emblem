package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import model.Tactician;
import model.items.*;
import model.map.Field;
import model.map.InvalidLocation;
import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */
class GameControllerTest {

  private GameController controller;
  private long randomSeed;
  private List<String> testTacticians;


  private Alpaca targetAlpaca;
  private Bow bow, bow2;
  private Field field;
  private Axe axe, axe2, axe3;
  private Sword sword, sword2;
  private Staff staff, staff2;
  private Spear spear, spear2;
  private IMagia anima, anima2, luz, luz2, oscuridad, oscuridad2;
  private Archer archer;
  private SwordMaster swordMaster;
  private Hero hero;
  private Fighter fighter;
  private Sorcerer sorcerer;
  private Alpaca alpaca;
  private Cleric cleric;

  /*public void setField() {
    this.field = new Field();
    for(int i = 0; i < controller.get; i++) {
      for (int j = 0; j < 3; j++) {
        Location actualLocation = new Location (i, j);
        actualLocation.setUnit(new NullUnit(actualLocation));
        this.field.addCells(false, actualLocation);

      }
    }
  }*/


  public void setWeapons() {
    this.axe = new Axe("Axe", 30, 1, 2);
    this.sword = new Sword("Sword", 30, 1, 2);
    this.spear = new Spear("Spear", 30, 1, 2);
    this.staff = new Staff("Staff", 30, 1, 2);
    this.bow = new Bow("Bow", 30, 2, 3);
    this.anima = new Anima("Anima", 30, 1, 2);
    this.luz = new Luz("Luz", 30, 1, 2);
    this.oscuridad = new Oscuridad("Oscuridad", 30, 1, 2);

    this.axe2 = new Axe("Axe2", 30, 1, 2);
    this.sword2 = new Sword("Sword2", 30, 1, 2);
    this.spear2 = new Spear("Spear2", 30, 1, 2);
    this.staff2 = new Staff("Staff2", 60, 1, 2);
    this.bow2 = new Bow("Bow2", 30, 2, 3);
    this.anima2 = new Anima("Anima2", 30, 1, 2);
    this.luz2 = new Luz("Luz2", 30, 1, 2);
    this.oscuridad2 = new Oscuridad("Oscuridad2", 30, 1, 2);

    this.axe3 = new Axe("Axe", 10, 1, 2);
  }

  public void setUnits(){
    archer = new Archer(300, 2, field.getCell(0, 0), bow, staff, anima);
    swordMaster = new SwordMaster(100, 2, field.getCell(1, 0), spear, sword);
    hero = new Hero(100, 2, field.getCell(0, 1), spear);
    fighter = new Fighter(100, 2, field.getCell(1, 2), axe);
    sorcerer = new Sorcerer(150, 2, field.getCell(2, 1), anima, luz, oscuridad);
    alpaca = new Alpaca(100, 2, field.getCell(2, 2), axe, spear, anima, sword);
    cleric = new Cleric(100, 2, field.getCell(1, 1), staff);
  }

  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests

    controller = new GameController(4, 4);
    randomSeed = controller.getGameMap().getSeed();
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
    //setField();
    field = controller.getGameMap();
    setWeapons();
    setUnits();

  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(4, gameMap.getSize());
    assertTrue(controller.getGameMap().isConnected());

    Random testRandom = new Random(randomSeed);
    long nuevaSeed = testRandom.nextLong();
    Field mapaDistinto = new Field();
    mapaDistinto.setSeed(nuevaSeed);


    Field gameMapIdentico = new Field();
    gameMapIdentico.setSeed(randomSeed);

    //se crean ambos mapas
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        gameMapIdentico.addCells(false, new Location(i, j));
        mapaDistinto.addCells(false, new Location(i, j));
      }
    }


    assertTrue(gameMap.equals(gameMapIdentico));
    assertNotEquals(gameMap, mapaDistinto);
  }

  @Test
  void getTurnOwner() {
    assertEquals("", controller.getTurnOwner().getName());
    long seed = controller.getSeed();
    Random r = new Random(seed);
    List<Tactician> copiaTactician = new ArrayList<>(controller.getTacticians());
    controller.initGame(2);
    Collections.shuffle(copiaTactician, r);
    assertEquals(copiaTactician.get(0).getName(), controller.getTurnOwner().getName());
  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {
      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    Random randomTurnSequence = new Random(randomSeed);
    Random randomTurnSequence2 = new Random(randomSeed);
    IntStream.range(0, 50).forEach(i -> {
      controller.initGame(randomTurnSequence.nextInt());
      assertEquals(randomTurnSequence2.nextInt(), controller.getMaxRounds());
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    controller.initGame(2);

    Tactician firstPlayer = controller.getTurnOwner();
    Tactician secondPlayer = controller.getOrdenTurnos().get(1);
    assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

    controller.endTurn();
    assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
    assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians().forEach(tactician -> assertNotEquals("Player 1", tactician));
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 5");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    IntStream.range(0, 8).forEach(i -> controller.endTurn());
    assertEquals(4, controller.getWinners().size());
    controller.getWinners()
        .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

    controller.initGame(2);
    IntStream.range(0, 4).forEach(i -> controller.endTurn());
    assertNull(controller.getWinners());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 3");
    IntStream.range(0, 2).forEach(i -> controller.endTurn());
    List<String> winners = controller.getWinners();
    assertEquals(2, winners.size());
    assertTrue(List.of("Player 1", "Player 2").containsAll(winners));

    controller.setTacticians(testTacticians);
    controller.initEndlessGame();
    for (int i = 0; i < 3; i++) {
      assertNull(controller.getWinners());
      controller.removeTactician("Player " + i);
    }
    assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster, hero));
    assertEquals(new NullUnit(new InvalidLocation()), controller.getSelectedUnit());
    controller.getTurnOwner().setUnitSelection(archer);
    assertEquals(archer, controller.getSelectedUnit());
  }

  @Test
  void selectUnitIn() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster, hero));
    assertNull(controller.getSelectUnitIn());
    controller.selectUnitIn(0, 0);
    assertEquals(archer, controller.getSelectUnitIn());
    controller.selectUnitIn(1, 0);
    assertEquals(swordMaster, controller.getSelectUnitIn());
    controller.selectUnitIn(1, 1);
    assertEquals(cleric, controller.getSelectUnitIn());
  }

  @Test
  void getItems() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster, hero));
    controller.getTurnOwner().setUnitSelection(archer);
    assertEquals(3, controller.getItems().size());
    controller.getTurnOwner().setUnitSelection(swordMaster);
    assertEquals(2, controller.getItems().size());
  }

  @Test
  void equipItem() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster, hero));
    controller.getTurnOwner().setUnitSelection(archer);
    assertEquals(new NullItem(), controller.getTurnOwner().getUnitSelection().getEquippedItem());
    controller.equipItem(0);
    assertEquals(bow, controller.getTurnOwner().getUnitSelection().getEquippedItem());
  }

  @Test
  void useItemOn() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster, hero));
    controller.getTurnOwner().setUnitSelection(archer);
    controller.equipItem(0);
    controller.selectUnitIn(1, 1);
    assertEquals(100, controller.getSelectUnitIn().getCurrentHitPoints());
    controller.useItemOn(1, 1);
    assertEquals(70, controller.getSelectUnitIn().getCurrentHitPoints());
  }

  @Test
  void selectItem() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster));
    controller.getTurnOwner().setUnitSelection(archer);
    assertEquals(archer, controller.getTurnOwner().getUnitSelection());
    assertNull(controller.getSelectItem());
    controller.selectItem(1);
    assertEquals(staff, controller.getSelectItem());
  }

  @Test
  void giveItemTo() {
    Tactician t = controller.getTacticians().get(0);
    controller.setTurnOwner(t);
    t.setUnits(List.of(archer, swordMaster));
    controller.selectUnitIn(1, 0);
    List<IEquipableItem> ola = controller.getSelectUnitIn().getItems();
    assertEquals(2, ola.size());
    controller.getTurnOwner().setUnitSelection(archer);
    assertEquals(archer, controller.getTurnOwner().getUnitSelection());
    controller.selectItem(1);
    assertEquals(staff, controller.getSelectItem());
    controller.giveItemTo(1, 0);
    assertEquals(3, controller.getSelectUnitIn().getItems().size());
    assertEquals(2, t.getUnitSelection().getItems().size());
  }
}