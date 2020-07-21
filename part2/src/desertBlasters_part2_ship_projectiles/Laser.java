package desertBlasters_part2_ship_projectiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a Laser.
 * 
 * @author Rissa Li
 *
 */
public class Laser extends Projectile {

	public static BufferedImage image;
	public static int laserWidth;
	public static int laserHeight;

	static {
		try {
			image = ImageIO.read(Ship.class.getResource("/images/laser.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		laserWidth = image.getWidth();
		laserHeight = image.getHeight();
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
		super(x, y, mY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desertBlasters_part2_ship_projectiles.Projectile#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, x - laserWidth / 2, y - laserHeight / 2, null);
	}
}