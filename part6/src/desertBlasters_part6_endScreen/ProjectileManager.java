package desertBlasters_part6_endScreen;

import java.awt.Graphics;

/**
 * Manages Projectiles.
 *
 * @author Rissa Li
 * @version 21 July, 2020
 */
public class ProjectileManager {

	public static Projectile[] projectiles;

	static {
		projectiles = new Projectile[100];
	}

	/**
	 * Creates a new Projectile if space is available in the array with a 3%
	 * success rate.
	 */
	public static void createProjectiles() {
		// If we spawn a Projectile every time this method is called, the screen
		// would be flooded with Projectiles. We do not want that.
		if (Math.random() > 0.03)
			return;

		for (int i = 0; i < projectiles.length; i++) {
			if (projectiles[i] == null) {
				// 50% chance of spawning an Astroid or an Alien.
				if (Math.random() <= 0.5) {
					int x = (int) (Math.random()
							* (Main.screenWidth - Astroid.astroidWidth + 1)
							+ Astroid.astroidWidth / 2);
					int mY = (int) (Math.random() * 6) + 1;
					projectiles[i] = new Astroid(x, mY);
				} else {
					int x = (int) (Math.random()
							* (Main.screenWidth - Alien.alienWidth + 1)
							+ Alien.alienWidth / 2);
					int mY = (int) (Math.random() * 6) + 1;
					projectiles[i] = new Alien(x, mY);
				}
				break;
			}
		}
	}

	/**
	 * Moves all Projectiles.
	 */
	public static void move() {
		Projectile projectile;

		for (int i = 0; i < projectiles.length; i++) {
			projectile = projectiles[i];
			if (projectile != null) {
				projectile.move();
			}
		}
	}

	/**
	 * Checks if any Projectiles have collided with the Ship.
	 * 
	 * @param ship
	 *            ship to collide with
	 */
	public static void collided(Ship ship) {
		Projectile projectile;

		for (int i = 0; i < projectiles.length; i++) {
			projectile = projectiles[i];
			if (projectile != null) {
				projectile.collided(ship);
			}
		}
	}

	/**
	 * Draws all Projectiles.
	 * 
	 * @param g
	 *            Graphics
	 */
	public static void draw(Graphics g) {
		Projectile projectile;

		for (int i = 0; i < projectiles.length; i++) {
			projectile = projectiles[i];
			if (projectile != null) {
				projectile.draw(g);
				if (projectile.isOutOfBounds() || projectile.hasCollided) {
					projectiles[i] = null;
				}
			}
		}
	}
}