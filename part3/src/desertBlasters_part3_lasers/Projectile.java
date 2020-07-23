package desertBlasters_part3_lasers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Represents a Projectile.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Projectile {

	public BufferedImage image;
	public int x;
	public int y;
	public int mY;
	public int leftEdge;
	public int rightEdge;
	public int topEdge;
	public int bottomEdge;

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
	public Projectile(BufferedImage image, int x, int y, int mY) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.mY = mY;
		leftEdge = x - image.getWidth() / 2;
		rightEdge = x + image.getWidth() / 2;
		topEdge = y - image.getHeight() / 2;
		bottomEdge = y + image.getHeight() / 2;
	}

	/**
	 * Moves this Projectile.
	 */
	public void move() {
		y += mY;
		topEdge = y - image.getHeight() / 2;
		bottomEdge = y + image.getHeight() / 2;
	}

	/**
	 * Draws this Projectile.
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(image, leftEdge, topEdge, null);
	}
}