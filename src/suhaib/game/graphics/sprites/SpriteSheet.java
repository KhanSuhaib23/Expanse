package suhaib.game.graphics.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private final String path;
	public int[] pixels;
	public int size;
	
	public static SpriteSheet maptiles = new SpriteSheet("/textures/tiles/maptiles.png");
	public static SpriteSheet spawn_level_tiles = new SpriteSheet ("/textures/tiles/spawn_level_tiles.png");
	public static SpriteSheet mobs = new SpriteSheet("/textures/sprites/sprites.png");
	public static SpriteSheet open_level_tiles = new SpriteSheet("/textures/tiles/open_level_tiles.png");
	
	public SpriteSheet(String path){
		this.path = path;
		load();
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			size = w;
			pixels = new int[size * size];
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
