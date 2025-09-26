package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//LaserTurret: stationary hazard on the board.
public class LaserTurret extends GamePiece {
	public LaserTurret(int location) {
		super('L', "Laser Turret", location);
	}

	//if player on same square -> HIT, else NONE
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}

