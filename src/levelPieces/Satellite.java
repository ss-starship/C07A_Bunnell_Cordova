package levelPieces;

import java.util.Random;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Satellite extends GamePiece implements Moveable {
    private Random rand = new Random();

    //Constructor
    public Satellite(int location) {
        super('@', "Satellite", location);
    }

    // Moves randomly left, right, or stays
    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int dir = rand.nextInt(3) - 1; // -1, 0, or 1
        int newLocation = getLocation() + dir;

        // stay within board limits
        if (newLocation >= 0 && newLocation < GameEngine.BOARD_SIZE) {
            setLocation(newLocation);
        }
    }

    // If player on same square then HIT
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}