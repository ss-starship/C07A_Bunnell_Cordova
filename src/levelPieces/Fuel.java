package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Fuel extends GamePiece {
    public Fuel(int location) {
        super('F', "Fuel Cell", location);
    }

    //if player on same square -> GET_POINT, else NONE
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            return InteractionResult.GET_POINT;
        }
        return InteractionResult.NONE;
    }
}
