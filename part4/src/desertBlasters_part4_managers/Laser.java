package desertBlasters_part4_managers;

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
}