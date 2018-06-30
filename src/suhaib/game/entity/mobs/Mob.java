package suhaib.game.entity.mobs;

import suhaib.game.Game;
import suhaib.game.entity.Entity;
import suhaib.game.entity.projectiles.Projectile;
import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;
import suhaib.game.input.Mouse;
import suhaib.game.level.Level;
import suhaib.game.level.PortalLevel;

public class Mob extends Entity {

	protected int direction = 0; // North East South West 0 1 2 3
	protected int xMove = 0, yMove = 0;
	protected boolean moving = false;
	protected int speed = 2;
	protected int animation = 0;
	public static int xLocation = 124 << 4, yLocation = 118 << 4;

	public Mob(int x, int y, Sprite[] sprite, Level level, PortalLevel portal_level) {
		super(x, y);
		direction = 0;
		for (int i = 0; i < sprite.length; i++) {
			this.sprite = sprite;
		}
		level.add(this);
		this.level = level;
		this.portal_level = portal_level;
		
	}

	public void update() {
		
	}
	
//	public void shoot(double angle){
//		Projectile p = new Projectile(angle, Sprite.flower);
//		level.addProjectile(p);
//	}
	

	public void render() {

	}

	public void initializeLevel(Level level) {
		this.level = level;
	}


	protected void move(int xMove, int yMove) {
		if (xMove != 0 && yMove != 0) {
			move(xMove, 0);
			move(0, yMove);
			return;
		}
		if (xMove > 0) direction = 1;
		else if (xMove < 0) direction = 3;

		if (yMove > 0) direction = 2;
		else if (yMove < 0) direction = 0;
		if (collision((x + xMove), (y + yMove))) {
			if (portal_level.tiles[(x >> 4) + (y >> 4) * portal_level.width] != 0xffffff) {
				if (portal_level.tiles[(x >> 4) + (y >> 4) * portal_level.width] == 0xff000000) {
					if (yMove > 0){
						Game.changeLevel(0);
					}
				}
				else if (portal_level.tiles[(x >> 4) + (y >> 4) * portal_level.width] == 0xff000001) {
					Game.changeLevel(1);
				}
				else if (portal_level.tiles[(x >> 4) + (y >> 4) * portal_level.width] == 0xff000002) {
					if (yMove < 0) {
						xLocation = x;
						yLocation = y;
						Game.changeLevel(2);
					}
				}
				else if (portal_level.tiles[(x >> 4) + (y >> 4) * portal_level.width] == 0xffff0002) {
					if (yMove > 0) {
						xLocation = 110 << 4;
						yLocation = 120 << 4;
						Game.changeLevel(1);
					}
				}
			}
		}
		

		else {
			x += xMove;
			y += yMove;
		}

	}

	public void render(Display display) {

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean collision(int x, int y) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x + c % 2 * 6 + 4) / 16;
			int yt = (y + c / 2 * 4 + 10) / 16;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}

}
