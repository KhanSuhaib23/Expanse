package suhaib.game.level.tile;

import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;

public class VoidTile extends Tile{

	public VoidTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void render(Display display, int x, int y) {
		display.renderTile(x << 4, y << 4, this);
	}

	@Override
	public boolean solid() {
		return true;
	}

	@Override
	public boolean projectileSolid() {
		
		return true;
	}

}
