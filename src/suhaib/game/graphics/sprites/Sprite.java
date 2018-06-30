package suhaib.game.graphics.sprites;

public class Sprite {

	private SpriteSheet sheet;
	public int size;
	private int x, y;
	public int[] pixels;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.maptiles);
	public static Sprite rock = new Sprite(16, 1, 0, SpriteSheet.maptiles);
	public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.maptiles);
	public static Sprite water = new Sprite(16, 3, 0, SpriteSheet.maptiles);
	public static Sprite grass_water_1 = new Sprite(16, 0, 1, SpriteSheet.maptiles);
	public static Sprite grass_water_2 = new Sprite(16, 1, 1, SpriteSheet.maptiles);
	public static Sprite grass_water_3 = new Sprite(16, 2, 1, SpriteSheet.maptiles);
	public static Sprite grass_water_4 = new Sprite(16, 3, 1, SpriteSheet.maptiles);

	// Spawn Level Sprites
	public static Sprite spawn_level_floor = new Sprite(16, 0, 0, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_wall = new Sprite(16, 1, 0, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_chest = new Sprite(16, 2, 0, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_door1 = new Sprite(16, 3, 0, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_door2 = new Sprite(16, 3, 1, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_window = new Sprite(16, 0, 1, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_chest_sword = new Sprite(16, 1, 1, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_chest_apple = new Sprite(16, 2, 1, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_table1 = new Sprite(16, 0, 2, SpriteSheet.spawn_level_tiles);
	public static Sprite spawn_level_table2 = new Sprite(16, 1, 2, SpriteSheet.spawn_level_tiles);
	// Void Tile
	public static Sprite void_tile = new Sprite(16, 0x000000);
	
	//Open Level Tiles
	public static Sprite open_level_house1 = new Sprite(16, 0, 0, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house2 = new Sprite(16, 1, 0, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house3 = new Sprite(16, 2, 0, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house4 = new Sprite(16, 0, 1, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house5 = new Sprite(16, 1, 1, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house6 = new Sprite(16, 2, 1, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house7 = new Sprite(16, 0, 2, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house8 = new Sprite(16, 1, 2, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house9 = new Sprite(16, 2, 2, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house10= new Sprite(16, 0, 3, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house11 = new Sprite(16, 1, 3, SpriteSheet.open_level_tiles);
	public static Sprite open_level_house12 = new Sprite(16, 2, 3, SpriteSheet.open_level_tiles);
	
	public static Sprite open_level_dungeon_front = new Sprite(16, 3, 0, SpriteSheet.open_level_tiles);
	public static Sprite open_level_dungeon_back = new Sprite(16, 3, 1, SpriteSheet.open_level_tiles);

	// Player
	public static Sprite[] player_bare_hand = {new Sprite(16, 0, 0, SpriteSheet.mobs), new Sprite(16, 1, 0, SpriteSheet.mobs), new Sprite(16, 2, 0, SpriteSheet.mobs), new Sprite(16, 3, 0, SpriteSheet.mobs), new Sprite(16, 4, 0, SpriteSheet.mobs), new Sprite(16, 5, 0, SpriteSheet.mobs), new Sprite(16, 6, 0, SpriteSheet.mobs), new Sprite(16, 7, 0, SpriteSheet.mobs), new Sprite(16, 8, 0, SpriteSheet.mobs), new Sprite(16, 9, 0, SpriteSheet.mobs)};
	public static Sprite bullet = new Sprite(16, 0, 5, SpriteSheet.mobs);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.size = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[size * size];
		load();
	}

	public Sprite(int size, int color) {
		this.size = size;
		pixels = new int[size * size];
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.size];
			}
		}
	}
}
