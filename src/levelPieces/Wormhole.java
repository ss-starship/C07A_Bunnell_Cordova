package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Wormhole extends GamePiece{
    public Wormhole(int location) {
        super('O', "Wormhole", location);
    }

    //if player on same square -> ADVANCE, else NONE
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            return InteractionResult.ADVANCE;
        }
        return InteractionResult.NONE;
    }
}
