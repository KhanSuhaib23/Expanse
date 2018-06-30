package suhaib.game.entity.projectiles;

import java.util.Random;

import suhaib.game.entity.Entity;
import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;


public class Projectile extends Entity {
	
	private static Random random = new Random();

	public static int xOrigin = (300 / 2 * 3) + 8 * 3, yOrigin = (((300 / 16) * 9) / 2 * 3) + 8 * 3;
	private double angle;
	public int range = 150 + random.nextInt(40);
	private int speed = 5;
	public static int rateOfFire = 10;
	private int damage;
	private double xIncreement, yIncreement;
	public double xProjectile;
	public double yProjectile;
	protected Sprite spriteProjectile;

	public Projectile(int x, int y, double angle, Sprite sprite) {

		xIncreement = speed * Math.cos(angle);
		yIncreement = speed * Math.sin(angle);
		// System.out.println(xIncreement + " , " + yIncreement );
		spriteProjectile = sprite;
		xProjectile = x;
		yProjectile = y;
	}

	public Projectile() {

	}

	public void updateProjectiles() {
		xProjectile += xIncreement;
		yProjectile += yIncreement;

		// System.out.println(xProjectile+ " , " + yProjectile);
	}

	public void renderProjectile(Display display) {
		display.renderSprite((int) xProjectile, (int) yProjectile, spriteProjectile);
	}

}
