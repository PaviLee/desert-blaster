package desertBlasters_part7_encapsulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Run Desert Blaster from this class.
 * 
 * @author Rissa Li
 * @version July 16, 2020
 */
public class Main {

	public static final int screenWidth = 800;
	public static final int screenHeight = 700;

	private static boolean gameOver = false;
	private static BufferedImage endScreenImage;

	static {
		try {
			endScreenImage = ImageIO
					.read(Astroid.class.getResource("/images/gameOver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Screen screen = new Screen(screenWidth, screenHeight);
		Graphics g = screen.getScreenGraphics();

		Ship ship = new Ship(screenWidth / 2, screenHeight / 2);
		screen.addMouseMotionListener(ship);
		screen.getJFrame().addKeyListener(ship);

		while (!gameOver) {
			screen.clearScreen();

			ProjectileManager.createProjectiles();
			ProjectileManager.move();
			ProjectileManager.collided(ship);
			ProjectileManager.draw(g);

			LaserManager.move();
			LaserManager.collided(ProjectileManager.getProjectiles());
			LaserManager.collided(ship);
			LaserManager.draw(g);

			ship.draw(g);

			screen.repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		showEndScreen(g, screen);
	}

	/**
	 * Sets gameOver to inputed boolean.
	 * 
	 * @param gameOver
	 *            new gameOver value
	 */
	public static void setGameOver(boolean gameOver) {
		Main.gameOver = gameOver;
	}

	/**
	 * Shows the end screen.
	 * 
	 * @param g
	 *            Graphics
	 * @param screen
	 *            Screen
	 */
	private static void showEndScreen(Graphics g, Screen screen) {
		g.drawImage(endScreenImage,
				screenWidth / 2 - endScreenImage.getWidth() / 2,
				screenHeight / 2 - endScreenImage.getHeight() / 2, null);
		screen.repaint();
	}
}