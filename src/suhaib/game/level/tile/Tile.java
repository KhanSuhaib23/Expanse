package suhaib.game.level.tile;

import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;

public abstract class Tile {
	public Sprite sprite;
	
	public int x0, x1, y0, y1;
	
	public static Tile grass = new NonSolidTile(Sprite.grass);
	public static final int COL_GRASS = 0xff247a00;
	public static Tile flower = new NonSolidTile(Sprite.flower);
	public static final int COL_FLOWER = 0xffffff00;
	public static Tile rock = new SolidTile(Sprite.rock);
	public static final int COL_ROCK = 0xff808080;
	public static Tile water = new NonSolidProjectileTile(Sprite.water);
	public static final int COL_WATER= 0xff0094ff;
	public static Tile grass_water_1 = new NonSolidProjectileTile(Sprite.grass_water_1);  // Water Bottom Right
	public static final int COL_GRASS_WATER_1 = 0xff14ffff;
	public static Tile grass_water_2 = new NonSolidProjectileTile(Sprite.grass_water_2); // Water Top Right
	public static final int COL_GRASS_WATER_2 = 0xff3afffb;
	public static Tile grass_water_3 = new NonSolidProjectileTile(Sprite.grass_water_3);  // Water Top Left
	public static final int COL_GRASS_WATER_3 = 0xff4cfff3;
	public static Tile grass_water_4 = new NonSolidProjectileTile(Sprite.grass_water_4);  // Water Bottom Left
	public static final int COL_GRASS_WATER_4 = 0xff5bfff6;
	
	//Spawn Level Tiles
	public static Tile spawn_level_floor = new NonSolidTile(Sprite.spawn_level_floor);
	public static final int COL_SPAWN_LEVEL_FLOOR = 0xff602a0a;
	
	public static Tile spawn_level_wall = new SolidTile(Sprite.spawn_level_wall);
	public static final int COL_SPAWN_LEVEL_WALL = 0xffa93b2e;
	
	public static Tile spawn_level_chest = new SolidTile(Sprite.spawn_level_chest);
	public static final int COL_SPAWN_LEVEL_CHEST = 0xffb5b500;
	
	public static Tile spawn_level_door1 = new SolidTile(Sprite.spawn_level_door1);
	public static final int COL_SPAWN_LEVEL_DOOR1 = 0xff7a5239;
	
	public static Tile spawn_level_door2 = new SolidTile(Sprite.spawn_level_door2);
	public static final int COL_SPAWN_LEVEL_DOOR2 = 0xff562c13;
	
	public static Tile spawn_level_window = new SolidTile(Sprite.spawn_level_window);
	public static final int COL_SPAWN_LEVEL_WINDOW = 0xff29abe1;
	
	public static Tile spawn_level_chest_sword = new SolidTile(Sprite.spawn_level_chest_sword);
	public static final int COL_SPAWN_LEVEL__CHEST_SWORD = 0xff898989;
	
	public static Tile spawn_level_chest_apple = new SolidTile(Sprite.spawn_level_chest_apple);
	public static final int COL_SPAWN_LEVEL_CHEST_APPLE = 0xffff0000;
	
	public static Tile spawn_level_table1 = new SolidTile(Sprite.spawn_level_table1);
	public static final int COL_SPAWN_LEVEL_TABLE1= 0xff381d0f;
	
	public static Tile spawn_level_table2 = new SolidTile(Sprite.spawn_level_table2);
	public static final int COL_SPAWN_LEVEL_TABLE2 = 0xff381d1f;
	
	//Void Level Tiles
	public static Tile void_tile = new VoidTile(Sprite.void_tile);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	//Open Level Tiles
	public static Tile open_level_house1 = new SolidTile(Sprite.open_level_house1);
	public static final int COL_OPEN_LEVEL_HOUSE1 = 0xff151515;
	public static Tile open_level_house2 = new SolidTile(Sprite.open_level_house2);
	public static final int COL_OPEN_LEVEL_HOUSE2 = 0xffaaaaaa;
	public static Tile open_level_house3 = new SolidTile(Sprite.open_level_house3);
	public static final int COL_OPEN_LEVEL_HOUSE3 = 0xff6E6E6E;
	public static Tile open_level_house4 = new SolidTile(Sprite.open_level_house4);
	public static final int COL_OPEN_LEVEL_HOUSE4 = 0xff202020;
	public static Tile open_level_house5 = new SolidTile(Sprite.open_level_house5);
	public static final int COL_OPEN_LEVEL_HOUSE5 = 0xffC5C5C5;
	public static Tile open_level_house6 = new SolidTile(Sprite.open_level_house6);
	public static final int COL_OPEN_LEVEL_HOUSE6 = 0xff8F8F8F;
	public static Tile open_level_house7 = new SolidTile(Sprite.open_level_house7);
	public static final int COL_OPEN_LEVEL_HOUSE7 = 0xff010101;
	public static Tile open_level_house8 = new SolidTile(Sprite.open_level_house8);
	public static final int COL_OPEN_LEVEL_HOUSE8 = 0xff4B4B4B;
	public static Tile open_level_house9 = new SolidTile(Sprite.open_level_house9);
	public static final int COL_OPEN_LEVEL_HOUSE9 = 0xff888888;
	public static Tile open_level_house10 = new SolidTile(Sprite.open_level_house10);
	public static final int COL_OPEN_LEVEL_HOUSE10 = 0xff111111;
	public static Tile open_level_house11 = new SolidTile(Sprite.open_level_house11);
	public static final int COL_OPEN_LEVEL_HOUSE11 = 0xff111112;
	public static Tile open_level_house12 = new SolidTile(Sprite.open_level_house12);
	public static final int COL_OPEN_LEVEL_HOUSE12 = 0xff111113;
	
	public static Tile open_level_dungeon_front = new SolidTile(Sprite.open_level_dungeon_front);
	public static final int COL_OPEN_LEVEL_DUNGEON_FRONT = 0xffa0a0a0;
	public static Tile open_level_dungeon_back = new SolidTile(Sprite.open_level_dungeon_back);
	public static final int COL_OPEN_LEVEL_DUNGEON_BACK = 0xff5b5b5b;
	
	
	
	
	public abstract void render(Display display, int x, int y);
	public abstract boolean solid();
	public abstract boolean projectileSolid();
}
