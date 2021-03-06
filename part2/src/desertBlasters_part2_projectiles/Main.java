package desertBlasters_part2_projectiles;

import java.awt.Graphics;

/**
 * Run Desert Blaster from this class.
 * 
 * @author Rissa Li
 * @version July 16, 2020
 */
public class Main {

	public static int screenWidth = 800;
	public static int screenHeight = 700;

	public static void main(String[] args) {
		Screen screen = new Screen(screenWidth, screenHeight);
		Graphics g = screen.getScreenGraphics();

		Ship ship = new Ship(screenWidth / 2, screenHeight / 2);
		screen.addMouseMotionListener(ship);

		Alien alien = new Alien(300, 5);
		Astroid astroid = new Astroid(500, 5);

		while (true) {
			screen.clearScreen();

			alien.move();
			astroid.move();

			alien.draw(g);
			astroid.draw(g);

			ship.draw(g);

			screen.repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}