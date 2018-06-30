package suhaib.game.entity.object;

import suhaib.game.entity.Entity;
import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;
import suhaib.game.level.Level;

public class Object extends Entity {

	protected boolean breakable, interractable, solid;
	
	public Object(int x, int y, Level level, Sprite[] sprite, boolean breakable, boolean interractable, boolean solid) {
		super(x, y);
		for (int i = 0; i < sprite.length; i++) {
			this.sprite = sprite;
		}
		level.add(this);
		this.breakable = breakable;
		this.interractable = interractable;
		this.solid = solid;
		
	}

	public void render(Display display) {
		
	}


}
