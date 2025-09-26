package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelSetup {
	// Each level has a 1D array for the board containing pieces that can be drawn
	// or null for empty
	private Drawable[] gameBoard;
	// Only some pieces can move.
	private ArrayList<Moveable> movingPieces;
	// Only game pieces interact
	private ArrayList<GamePiece> interactingPieces;
	//player start
	private int playerStart; 
	
	//setup for  levels
    public void createLevel(int lvlNum) {
        if (lvlNum == 1) {
            level1(); // setup for first level
        } else if (lvlNum == 2) {
            level2(); // setup for second level
        }
		
	}
    
    //Getters to pull data
    public Drawable[] getBoard() {
    		return gameBoard;
    }
    
    public ArrayList<Moveable> getMovingPieces() {
        return movingPieces;
    }

    public ArrayList<GamePiece> getInteractingPieces() {
        return interactingPieces;
    }

    public int getPlayerStartLoc() {
        return playerStart;
    }
    
    //level 1
    //simple level: one collectible, one moving enemy, and exit
    private void level1() {
        //reset everything
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        movingPieces = new ArrayList<>();
        interactingPieces = new ArrayList<>();

        //set player start location (left edge)
        playerStart = 0;

        //create pieces w starting locations
        Asteroid asteroid = new Asteroid(2);   // decoration only
        Fuel fuel = new Fuel(4);               // gives a point
        AlienShip alien = new AlienShip(7);    // moves left/right
        Wormhole wormhole = new Wormhole(20);  // exit to next level

        //put them onto the gameBoard array
        gameBoard[asteroid.getLocation()] = asteroid;
        gameBoard[fuel.getLocation()] = fuel;
        gameBoard[alien.getLocation()] = alien;
        gameBoard[wormhole.getLocation()] = wormhole;

        //add them to extra lists (if needed)
        movingPieces.add(alien);          // AlienShip moves every turn
        interactingPieces.add(fuel);      // Fuel interacts (GET_POINT)
        interactingPieces.add(alien);     // AlienShip interacts
        interactingPieces.add(wormhole);  // Wormhole interacts (ADVANCE)
    }
    
    //level 2
    //increased difficulty: more hazards, one random-moving piece, deadly BlackHole
    private void level2() {
        //reset data
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        movingPieces = new ArrayList<>();
        interactingPieces = new ArrayList<>();

        playerStart = 0;

        //create pieces
        Satellite sat = new Satellite(3);        // random movement
        LaserTurret turret = new LaserTurret(6); // hits if stepped on
        Asteroid asteroid = new Asteroid(8);     // decoration
        Fuel fuel = new Fuel(10);                // gives point
        BlackHole blackHole = new BlackHole(15); // kills at distance
        Wormhole wormhole = new Wormhole(20);    // exit to next level

        //set pieces on the board
        gameBoard[sat.getLocation()] = sat;
        gameBoard[turret.getLocation()] = turret;
        gameBoard[asteroid.getLocation()] = asteroid;
        gameBoard[fuel.getLocation()] = fuel;
        gameBoard[blackHole.getLocation()] = blackHole;
        gameBoard[wormhole.getLocation()] = wormhole;

        //register pieces into lists
        movingPieces.add(sat);             // Satellite moves randomly
        interactingPieces.add(sat);        // Satellite can hurt player (HIT)
        interactingPieces.add(turret);     // Turret can hurt player (HIT)
        interactingPieces.add(fuel);       // Fuel gives a point (GET_POINT)
        interactingPieces.add(blackHole);  // BlackHole kills at a distance (KILL)
        interactingPieces.add(wormhole);   // Wormhole lets you advance (ADVANCE)
    }
}


