package desertBlasters_part7_encapsulation;

import java.awt.Graphics;

/**
 * Manages lasers.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class LaserManager {

	private static Laser[] lasers;

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
	 * Checks if any Lasers have collided with the Projectiles.
	 * 
	 * @param projectiles
	 *            Projectiles to collide with
	 */
	public static void collided(Projectile[] projectiles) {
		Laser laser;

		for (int i = 0; i < lasers.length; i++) {
			laser = lasers[i];
			if (laser == null) {
				continue;
			}
			for (int j = 0; j < projectiles.length; j++) {
				if (projectiles[j] != null) {
					laser.collided(projectiles[j]);
					if (laser.hasCollided) {
						break;
					}
				}
			}
		}
	}

	/**
	 * Checks if any Lasers have collided with the Ship.
	 * 
	 * @param ship
	 *            ship to collide with
	 */
	public static void collided(Ship ship) {
		Laser laser;

		for (int i = 0; i < lasers.length; i++) {
			laser = lasers[i];
			if (laser != null) {
				laser.collided(ship);
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
				if (laser.isOutOfBounds() || laser.hasCollided) {
					lasers[i] = null;
				}
			}
		}
	}
}