package suhaib.game.graphics;

import suhaib.game.graphics.sprites.Sprite;
import suhaib.game.level.tile.Tile;

public class Display {
	public int width;
	public int height;
	private int xOffSet;
	private int yOffSet;
	
	public int[] pixels;
	
	public Display(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(){
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = 0x000000;
		}
	}
	
	public void renderTile(int xPos, int yPos, Tile tile){
		int xAbsolute;
		int yAbsolute;
		xPos -= xOffSet;
		yPos -= yOffSet;
		for (int y = 0; y < tile.sprite.size; y++){
			yAbsolute = y + yPos;
			if (yAbsolute < -tile.sprite.size || yAbsolute >= height) break;
			if (yAbsolute < 0) yAbsolute = 0;
			for (int x = 0; x < tile.sprite.size; x++){
				xAbsolute = x + xPos;
				if (xAbsolute < -tile.sprite.size || xAbsolute >= width) break;
				if (xAbsolute < 0) xAbsolute = 0;
				pixels[xAbsolute + yAbsolute * width] = tile.sprite.pixels[x + y * tile.sprite.size];
			}
		}
	}
	
	public void renderSprite(int xPos, int yPos, Sprite sprite){
		int xAbsolute;
		int yAbsolute;
		xPos -= xOffSet;
		yPos -= yOffSet;
		int color;
		for (int y = 0; y < sprite.size; y++){
			yAbsolute = y + yPos;
			if (yAbsolute < -sprite.size || yAbsolute >= height) break;
			if (yAbsolute < 0) yAbsolute = 0;
			for (int x = 0; x < sprite.size; x++){
				xAbsolute = x + xPos;
				if (xAbsolute < -sprite.size || xAbsolute >= width) break;
				if (xAbsolute < 0) xAbsolute = 0;
				color = sprite.pixels[x + y * sprite.size];
				if (color != 0xffff00ff){
				pixels[xAbsolute + yAbsolute * width] = color;
				}
			}
		}
	}
	
	public void setOffSet(int xOffSet, int yOffSet){
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
	}
	
	

}
