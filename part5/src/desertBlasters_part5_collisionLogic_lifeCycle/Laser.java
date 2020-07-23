package desertBlasters_part5_collisionLogic_lifeCycle;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a Laser. A Projectile with a custom image that can collide with
 * other Projectiles.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Laser extends Projectile {

	public static BufferedImage laserImage;
	public static int laserHeight;

	static {
		try {
			laserImage = ImageIO
					.read(Ship.class.getResource("/images/laser.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		laserHeight = laserImage.getHeight();
	}

	/**
	 * Creates a new Laser.
	 * 
	 * @param x
	 *            starting x
	 * @param y
	 *            starting y
	 * @param mY
	 *            movement y
	 */
	public Laser(int x, int y, int mY) {
		super(laserImage, x, y, mY);
	}

	public void collided(Projectile projectile) {
		// If this laser has already collided with a projectile, do nothing. We
		// do not want to reassign hasCollided on accident.
		if (hasCollided) {
			return;
		}

		hasCollided = (isBetween(leftEdge, projectile.leftEdge,
				projectile.rightEdge)
				|| isBetween(rightEdge, projectile.leftEdge,
						projectile.rightEdge))
				&& (isBetween(topEdge, projectile.topEdge,
						projectile.bottomEdge)
						|| isBetween(bottomEdge, projectile.topEdge,
								projectile.bottomEdge));

		if (hasCollided) {
			projectile.hasCollided = true;
		}
	}
}