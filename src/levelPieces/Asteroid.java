package levelPieces;

import gameEngine.Drawable;

//Asteroid (cannot interact)

public class Asteroid implements Drawable{

	private char symbol;
	private int location;

	//Constructor
	public Asteroid(int location) {
		this.symbol = '*';
		this.location = location;
	}

	//Draw symbol
	public void draw() {
		System.out.print(symbol);
	}

	//location for board placement
	public int getLocation() {
		return location;
	}

	//Update location
	public void setLocation(int newLocation) {
		this.location = newLocation;
	}
}

