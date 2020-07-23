package desertBlasters_part7_encapsulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a Projectile.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Projectile {

	public static final int explosionWidth;
	public static final int explosionHeight;

	private static BufferedImage explosion;

	protected BufferedImage image;
	protected int x;
	protected int y;
	protected int mY;
	protected int leftEdge;
	protected int rightEdge;
	protected int topEdge;
	protected int bottomEdge;
	protected boolean hasCollided;

	static {
		try {
			explosion = ImageIO
					.read(Astroid.class.getResource("/images/explosion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		explosionWidth = explosion.getWidth();
		explosionHeight = explosion.getHeight();
	}

	/**
	 * Returns a BufferedImage that contains an explosion image.
	 * 
	 * @return explosionImage.
	 */
	public static BufferedImage getExplosionImage() {
		return explosion;
	}

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
	 * Returns true if this Projectile is out of the Screen; false otherwise.
	 * 
	 * @return true if this Projectile is out of the Screen; false otherwise.
	 */
	public boolean isOutOfBounds() {
		return bottomEdge < 0 || topEdge > Main.screenHeight;
	}

	/**
	 * Checks if this Projectile has collided with a ship object.
	 * 
	 * @param ship
	 *            ship to collide with
	 */
	public void collided(Ship ship) {
		// If this projectile has already collided with the ship, do nothing. We
		// do not want to reassign hasCollided on accident.
		if (hasCollided) {
			return;
		}

		hasCollided = (isBetween(leftEdge, ship.getLeftEdge(),
				ship.getRightEdge())
				|| isBetween(rightEdge, ship.getLeftEdge(),
						ship.getRightEdge()))
				&& (isBetween(topEdge, ship.getTopEdge(), ship.getBottomEdge())
						|| isBetween(bottomEdge, ship.getTopEdge(),
								ship.getBottomEdge()));

		if (hasCollided) {
			ship.setHasCollided(true);
		}
	}

	/**
	 * Returns true if value if between the two bounds; false otherwise. Helper
	 * method for collided(Ship ship).
	 * 
	 * @param value
	 *            int value to check
	 * @param bound1
	 *            first bound
	 * @param bound2
	 *            second bound
	 * @return true if value if between the two bounds; false otherwise.
	 */
	protected boolean isBetween(int value, int bound1, int bound2) {
		return value >= bound1 && value <= bound2;
	}

	/**
	 * Draws this Projectile.
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(image, leftEdge, topEdge, null);
		if (hasCollided) {
			g.drawImage(Projectile.explosion, x - Projectile.explosionWidth / 2,
					y - Projectile.explosionHeight / 2, null);
		}
	}
}