package suhaib.game.entity.mobs;

import suhaib.game.entity.projectiles.Projectile;
import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;
import suhaib.game.input.Keyboard;
import suhaib.game.input.Mouse;
import suhaib.game.level.Level;
import suhaib.game.level.PortalLevel;

public class Player extends Mob {

	private Keyboard key;
	protected boolean check = true;
	private int fireRate = Projectile.rateOfFire;

	public Player(int x, int y, Level level, Sprite[] sprite, Keyboard key, PortalLevel portal_level) {
		super(x, y, sprite, level, portal_level);
		this.key = key;
	}

	public void render(Display display) {
		Sprite selected_sprite = sprite[0];
		animation++;
		if (animation >= 10000) animation = 0;
		if (direction == 0) {
			if (moving) {
				if (animation % 30 < 15) {
					selected_sprite = sprite[5];
				}
				else {
					selected_sprite = sprite[9];
				}

			}
			else {
				selected_sprite = sprite[1];
			}
		}
		if (direction == 1) {
			if (moving) {
				if (animation % 30 < 15) {
					selected_sprite = sprite[2];
				}
				else {
					selected_sprite = sprite[6];
				}
			}
			else {
				selected_sprite = sprite[2];
			}
		}
		if (direction == 2) {
			if (moving) {
				if (animation % 30 < 15) {
					selected_sprite = sprite[4];
				}
				else {
					selected_sprite = sprite[8];
				}
			}
			else {
				selected_sprite = sprite[0];
			}
		}
		if (direction == 3) {
			if (moving) {
				if (animation % 30 < 15) {
					selected_sprite = sprite[3];
				}
				else {
					selected_sprite = sprite[7];
				}
			}
			else {
				selected_sprite = sprite[3];
			}
		}
		display.renderSprite(x, y, selected_sprite);
	}

	public void update() {
		if (Mouse.getButton() == 1){
			if (fireRate > 0) fireRate--;
			if (fireRate == 0){
				double dy = Mouse.getY() - Projectile.yOrigin;
				double dx = Mouse.getX() - Projectile.xOrigin;
				double angle = Math.atan2(dy, dx);
				shoot(angle);
				fireRate = Projectile.rateOfFire;
				
			}
			
		}
		if (key.up) yMove -= speed;
		if (key.down) yMove += speed;
		if (key.right) xMove += speed;
		if (key.left) xMove -= speed;
		if (xMove != 0 || yMove != 0) {
			move(xMove, yMove);
			moving = true;
		}
		else {
			moving = false;
		}
		xMove = 0;
		yMove = 0;

	}
	
	
	public void shoot(double angle){
		Projectile p1 = new Projectile(x, y, angle, Sprite.bullet);
		level.addProjectile(p1);
		
		/*Projectile p2 = new Projectile(x, y, angle + 0.523599, Sprite.bullet);
		level.addProjectile(p2);
		Projectile p3 = new Projectile(x, y, angle - 0.523599, Sprite.bullet);
		level.addProjectile(p3);*/
	}

}
