package desertBlasters_part2_ship_projectiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A Projectile with a custom image that uses Projectile's default methods.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Astroid extends Projectile {

	public static BufferedImage image;
	public static int astroidWidth;
	public static int astroidHeight;

	static {
		try {
			image = ImageIO.read(Astroid.class.getResource("/images/astroid.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		astroidWidth = image.getWidth();
		astroidHeight = image.getHeight();
	}

	/**
	 * Creates a new Astroid.
	 * 
	 * @param x
	 *            starting x
	 * @param mY
	 *            movement y
	 */
	public Astroid(int x, int mY) {
		super(x, -astroidHeight / 2, mY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desertBlasters_part2_ship_projectiles.Projectile#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, x - astroidWidth / 2, y - astroidHeight / 2, null);
	}
}