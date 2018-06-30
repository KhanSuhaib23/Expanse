package suhaib.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PortalLevel {

	public int[] tiles;
	public int width;
	public int height;

	public PortalLevel(String path) {
		loadPortalLevel(path);
	}
	
	private void loadPortalLevel(String path){
		try {
			BufferedImage image = ImageIO.read(PortalLevel.class.getResource(path));
			this.width = image.getWidth();
			this.height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
