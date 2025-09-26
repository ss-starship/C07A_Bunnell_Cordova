package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.GameEngine;


 //AlienShip: patrols.
 //extends GamePiece, moves left/right across the board.

 
public class AlienShip extends GamePiece implements Moveable {
    private boolean movingRight = true; // patrol direction

    // Constructor
    public AlienShip(int location) {
        super('A', "Alien Ship", location);
    }

    //patrols left/right, reverses at edges
    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int newLocation = getLocation();

        if (movingRight) {
            newLocation++;
            if (newLocation >= GameEngine.BOARD_SIZE - 1) {
                movingRight = false; // hit right edge
                newLocation--;
            }
        } else {
            newLocation--;
            if (newLocation <= 0) {
                movingRight = true; // hit left edge
                newLocation++;
            }
        }

        setLocation(newLocation);
    }

    //interaction: none
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        return InteractionResult.NONE;
    }
}
