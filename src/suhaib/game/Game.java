package suhaib.game;  // Convention The Spawn Level has code 0 and Opne Level has code 1, The code of a dungeon is the number of dungeon + 1. In color 000000 is a 
					  // portal to spawn level 000001 is a portal to open level from the enterance of a dungeon, ff000n if the exit from the dungeon with code n to the open world

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import suhaib.game.entity.mobs.Player;
import suhaib.game.entity.projectiles.Projectile;
import suhaib.game.graphics.Display;
import suhaib.game.graphics.sprites.Sprite;
import suhaib.game.input.Keyboard;
import suhaib.game.input.Mouse;
import suhaib.game.level.Level;
import suhaib.game.level.PortalLevel;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private final static int width = 300;
	private final static int height = width / 16 * 9;
	private final static int scale = 3;

	private long base_render_time = 0;
	private long base_update_time = 0;

	private final int RENDER_LIMIT = 60;
	private final int UPDATE_LIMIT = 60;

	private boolean render_check = true;
	private boolean update_check = true;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private static boolean running = false;

	private Thread thread;
	private JFrame frame;
	private Display display;
	private static Level level;
	private static PortalLevel portal_level;
	private static Keyboard key;
	private static Player player;
	private Mouse mouse;

	public Game() {

		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		display = new Display(width, height);
		level = new Level("/textures/level/spawn_level.png");
		portal_level = new PortalLevel("/textures/level/spawn_level_portal.png");
		// level = new Level("/textures/level/open_level.png");
		// portal_level = new PortalLevel("/textures/level/open_level_portal.png");
		key = new Keyboard();
		mouse = new Mouse();
		// player = new Player(123 << 4, 118 << 4, level, Sprite.player_bare_hand, key, portal_level);
		player = new Player(7 << 4, 9 << 4, level, Sprite.player_bare_hand, key, portal_level);
		player.initializeLevel(level);
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		frame = new JFrame();
	}

	private synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}

	private synchronized void stop() {
		running = false;
		try {
			thread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		key.update();
		//player.update();
		level.update();
	
	}

	private void render() {
		BufferStrategy buffer = getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}

		display.clear();
		level.render(player.getX() - width / 2, player.getY() - height / 2, display);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = display.pixels[i];
		}

		Graphics g = buffer.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		buffer.show();
	}

	public void run() {
		requestFocus();
		while (running) {
			if (render_check) {
				base_render_time = System.nanoTime();
				render_check = false;
			}
			if (update_check) {
				base_update_time = System.nanoTime();
				update_check = false;
			}

			long current_render_time = System.nanoTime();
			long current_update_time = current_render_time;

			long renders = 1_000_000_000 / RENDER_LIMIT;
			long updates = 1_000_000_000 / UPDATE_LIMIT;

			if (current_render_time - base_render_time >= renders) {
				render_check = true;
				render();
			}

			if (current_update_time - base_update_time >= updates) {
				update_check = true;
				update();
			}
		}
	}

	public static void changeLevel(int level_code) {

		if (level_code == 0) {

			level = new Level("/textures/level/spawn_level.png");
			portal_level = new PortalLevel("/textures/level/spawn_level_portal.png");
			player = new Player(7 << 4, 2 << 4, level, Sprite.player_bare_hand, key, portal_level);

		}
		if (level_code == 1) {
			level = new Level("/textures/level/open_level.png");
			portal_level = new PortalLevel("/textures/level/open_level_portal.png");
			player = new Player(Player.xLocation, Player.yLocation, level, Sprite.player_bare_hand, key, portal_level);
		}
		
		if (level_code == 2) {
			level = new Level("/textures/level/dungeon1_level.png");
			portal_level = new PortalLevel("/textures/level/dungeon1_level_portal.png");
			player = new Player(15 << 4, 2 << 2, level, Sprite.player_bare_hand, key, portal_level);
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		// player.initializeGame(game);
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);

		game.start();

	}

}
