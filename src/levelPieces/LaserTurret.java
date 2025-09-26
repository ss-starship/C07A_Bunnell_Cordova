package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class LaserTurret extends GamePiece {
	public LaserTurret(int location) {
		super('L', "Laser Turret", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}

