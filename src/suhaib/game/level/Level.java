package suhaib.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import suhaib.game.entity.Entity;
import suhaib.game.entity.mobs.Player;
import suhaib.game.entity.projectiles.Projectile;
import suhaib.game.graphics.Display;
import suhaib.game.level.tile.Tile;

public class Level {

	public int[] tiles;
	public int width;
	public int height;
	private static Random random = new Random();
	

	public List<Entity> entities = new ArrayList<Entity>();
	public List<Projectile> projectiles = new ArrayList<Projectile>();

	public Level(String path) {
		loadLevel(path);
	}
	
	
	

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateRandomLevel();
	}

	private void generateRandomLevel() {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(4);
		}
	}

	private void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(Level.class.getResource(path));
			this.width = image.getWidth();
			this.height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++){
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).updateProjectiles();
		}
		
	}

	public void add(Entity e) {
		entities.add(e);
	}
	
	public void addProjectile(Projectile p){
		projectiles.add(p);
	}
	
	public void removeProjectile(Projectile p) {
		projectiles.remove(p);
	}

	public void render(int xScroll, int yScroll, Display display) {
		display.setOffSet(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + display.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + display.height) >> 4;
		for (int y = y0; y <= y1; y++) {
			for (int x = x0; x <= x1; x++) {
				getTile(x, y).render(display, x, y);

			}
		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(display);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).renderProjectile(display);
			double distance = Math.sqrt((Math.pow((projectiles.get(i).xProjectile - entities.get(0).x), 2)) + (Math.pow((projectiles.get(i).yProjectile - entities.get(0).y), 2)));
			if (distance >= projectiles.get(i).range) {
				projectiles.remove(i);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return Tile.void_tile;
		else if (tiles[x + y * width] == Tile.COL_GRASS) return Tile.grass;
		else if (tiles[x + y * width] == Tile.COL_ROCK) return Tile.rock;
		else if (tiles[x + y * width] == Tile.COL_FLOWER) return Tile.flower;
		else if (tiles[x + y * width] == Tile.COL_WATER) return Tile.water;
		else if (tiles[x + y * width] == Tile.COL_GRASS_WATER_1) return Tile.grass_water_1;
		else if (tiles[x + y * width] == Tile.COL_GRASS_WATER_2) return Tile.grass_water_2;
		else if (tiles[x + y * width] == Tile.COL_GRASS_WATER_3) return Tile.grass_water_3;
		else if (tiles[x + y * width] == Tile.COL_GRASS_WATER_4) return Tile.grass_water_4;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_FLOOR) return Tile.spawn_level_floor;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_WALL) return Tile.spawn_level_wall;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_CHEST) return Tile.spawn_level_chest;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_DOOR1) return Tile.spawn_level_door1;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_DOOR2) return Tile.spawn_level_door2;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_WINDOW) return Tile.spawn_level_window;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL__CHEST_SWORD) return Tile.spawn_level_chest_sword;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_CHEST_APPLE) return Tile.spawn_level_chest_apple;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_TABLE1) return Tile.spawn_level_table1;
		else if (tiles[x + y * width] == Tile.COL_SPAWN_LEVEL_TABLE2) return Tile.spawn_level_table2;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE1) return Tile.open_level_house1;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE2) return Tile.open_level_house2;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE3) return Tile.open_level_house3;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE4) return Tile.open_level_house4;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE5) return Tile.open_level_house5;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE6) return Tile.open_level_house6;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE7) return Tile.open_level_house7;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE8) return Tile.open_level_house8;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE9) return Tile.open_level_house9;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE10) return Tile.open_level_house10;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE11) return Tile.open_level_house11;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_HOUSE12) return Tile.open_level_house12;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_DUNGEON_FRONT) return Tile.open_level_dungeon_front;
		else if (tiles[x + y * width] == Tile.COL_OPEN_LEVEL_DUNGEON_BACK) return Tile.open_level_dungeon_back;
		else return Tile.void_tile;
	}

}
