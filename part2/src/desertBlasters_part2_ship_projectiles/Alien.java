package desertBlasters_part2_ship_projectiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A Projectile with a custom image that shoots lasers.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Alien extends Projectile {

	public static BufferedImage image;
	public static int alienWidth;
	public static int alienHeight;

	public Laser laser;

	static {
		try {
			image = ImageIO.read(Alien.class.getResource("/images/alien.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		alienWidth = image.getWidth();
		alienHeight = image.getHeight();
	}

	/**
	 * Creates a new Alien.
	 * 
	 * @param x
	 *            starting x
	 * @param mY
	 *            movement y
	 */
	public Alien(int x, int mY) {
		super(x, -alienHeight / 2, mY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desertBlasters_part2_ship_projectiles.Projectile#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		if (Math.random() <= 0.04) {
			laser = new Laser(x, y + alienHeight / 2, 6);
		}
		if(laser != null) {
			laser.move();
			laser.draw(g);
		}
		g.drawImage(image, x - alienWidth / 2, y - alienHeight / 2, null);
	}
}
