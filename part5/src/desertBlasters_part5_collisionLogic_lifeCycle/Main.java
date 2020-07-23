package desertBlasters_part5_collisionLogic_lifeCycle;

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
	public static boolean gameOver = false;

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
			LaserManager.collided(ProjectileManager.projectiles);
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
	}
}