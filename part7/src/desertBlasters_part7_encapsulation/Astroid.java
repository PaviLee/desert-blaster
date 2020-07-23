package desertBlasters_part7_encapsulation;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents an Astroid. A Projectile with a custom image that uses
 * Projectile's default methods.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Astroid extends Projectile {

	public static final int astroidWidth;
	public static final int astroidHeight;

	private static BufferedImage astroidImage;

	static {
		try {
			astroidImage = ImageIO
					.read(Astroid.class.getResource("/images/astroid.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		astroidWidth = astroidImage.getWidth();
		astroidHeight = astroidImage.getHeight();
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
		super(astroidImage, x, -astroidHeight / 2, mY);
	}
}