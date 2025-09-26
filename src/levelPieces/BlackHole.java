package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//BlackHole: hazard.
//does not move.
//kills player if within 2 spaces.
public class BlackHole extends GamePiece {

	//Constructor
	public BlackHole(int location) {
		super('X', "Black Hole", location);
	}

	//if player within 2 spaces then KILL
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int distance = Math.abs(playerLocation - getLocation());

		if (distance > 0 && distance <= 2) {
			return InteractionResult.KILL;
		}

		//in case player lands directly on it
		if (playerLocation == getLocation()) {
			return InteractionResult.KILL;
		}

		return InteractionResult.NONE;
	}
}