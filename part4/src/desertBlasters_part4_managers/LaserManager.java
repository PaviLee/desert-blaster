package desertBlasters_part4_managers;

import java.awt.Graphics;

/**
 * Manages lasers.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class LaserManager {

	public static Laser[] lasers;

	static {
		lasers = new Laser[1000];
	}

	/**
	 * Adds a laser.
	 * 
	 * @param laser
	 *            laser to add
	 */
	public static void addLaser(Laser laser) {
		for (int i = 0; i < lasers.length; i++) {
			if (lasers[i] == null) {
				lasers[i] = laser;
				break;
			}
		}
	}

	/**
	 * Moves all Lasers.
	 */
	public static void move() {
		Laser laser;

		for (int i = 0; i < lasers.length; i++) {
			laser = lasers[i];
			if (laser != null) {
				laser.move();
			}
		}
	}

	/**
	 * Draws all Lasers.
	 * 
	 * @param g
	 *            Graphics
	 */
	public static void draw(Graphics g) {
		Laser laser;

		for (int i = 0; i < lasers.length; i++) {
			laser = lasers[i];
			if (laser != null) {
				laser.draw(g);
			}
		}
	}
}