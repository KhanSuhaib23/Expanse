package suhaib.game.level.tile;

import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;

public class NonSolidTile extends Tile{

	public NonSolidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(Display display, int x, int y) {
		display.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return false;
	}
	
	public boolean projectileSolid() {
		return false;
	}

}
