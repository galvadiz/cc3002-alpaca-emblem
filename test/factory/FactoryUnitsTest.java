package factory;

import factory.units.FactoryUnits;
import model.items.*;
import model.map.InvalidLocation;
import model.units.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryUnitsTest {

    private Archer archer, archer2;
    private Fighter fighter, fighter2;
    private Hero hero, hero2;
    private SwordMaster swordMaster, swordMaster2;
    private Sorcerer sorcerer, sorcerer2;
    private Alpaca alpaca, alpaca2;
    private Cleric cleric, cleric2;

    private FactoryUnits f;


    void setExpectedUnits(){
        archer2 = new Archer(100, 2, new InvalidLocation());
        alpaca2 = new Alpaca(100, 3, new InvalidLocation());
        cleric2 = new Cleric(100, 4, new InvalidLocation());
        fighter2 = new Fighter(100, 5, new InvalidLocation());
        hero2 = new Hero(100, 4, new InvalidLocation());
        sorcerer2 = new Sorcerer(100, 3, new InvalidLocation());
        swordMaster2 = new SwordMaster(100, 2, new InvalidLocation());
    }

    @BeforeEach
    void setUp(){
        f = new FactoryUnits();
        setExpectedUnits();
    }

    @Test
    void createArcherTest(){
        archer = f.createArcher();
        assertEquals(archer2, archer);
    }

    @Test
    void createAlpacaTest(){
        alpaca = f.createAlpaca();
        assertEquals(alpaca2, alpaca);
    }

    @Test
    void createClericTest(){
        cleric = f.createCleric();
        assertEquals(cleric2, cleric);
    }
    @Test
    void createFighterTest(){
        fighter = f.createFighter();
        assertEquals(fighter2, fighter);
    }
    @Test
    void createHeroTest(){
        hero = f.createHero();
        assertEquals(hero2, hero);
    }
    @Test
    void createSorcererTest(){
        sorcerer = f.createSorcerer();
        assertEquals(sorcerer2, sorcerer);
    }
    @Test
    void cerateSwordMasterTest(){
        swordMaster = f.createSwordMaster();
        assertEquals(swordMaster2, swordMaster);
    }

}