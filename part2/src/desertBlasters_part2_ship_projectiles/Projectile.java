package desertBlasters_part2_ship_projectiles;

import java.awt.Graphics;

/**
 * Represents a Projectile.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public abstract class Projectile {

	public int x;
	public int y;
	public int mY;

	/**
	 * Creates a new Projectile.
	 * 
	 * @param x
	 *            starting x
	 * @param y
	 *            starting y
	 * @param mY
	 *            movement y
	 */
	public Projectile(int x, int y, int mY) {
		this.x = x;
		this.y = y;
		this.mY = mY;
	}

	/**
	 * Moves this Projectile.
	 */
	public void move() {
		y += mY;
	}

	/**
	 * Draws this Projectile.
	 * 
	 * @param g
	 *            Graphics
	 */
	public abstract void draw(Graphics g);
}