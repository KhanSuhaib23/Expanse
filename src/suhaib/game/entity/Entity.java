package suhaib.game.entity;

import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;
import suhaib.game.level.Level;
import suhaib.game.level.PortalLevel;

public abstract class Entity {

	public int x = 0, y = 0;
	protected Sprite[] sprite;
	protected Level level;
	protected PortalLevel portal_level;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Entity() {

	}
	
	public void update(){
		
	}

	public void render(Display display) {
		
	}

	public void intializeLevel(Level level) {
		this.level = level;
	}

	public void addEntity(Entity e) {
		level.add(e);
	}

}
