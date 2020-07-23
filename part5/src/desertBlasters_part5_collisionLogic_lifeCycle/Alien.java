package desertBlasters_part5_collisionLogic_lifeCycle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents an Alien. A Projectile with that moves diagonally and shoots
 * lasers.
 * 
 * @author Rissa Li
 * @version July 21, 2020
 */
public class Alien extends Projectile {

	public static BufferedImage alienImage;
	public static int alienWidth;
	public static int alienHeight;

	public int mX;

	static {
		try {
			alienImage = ImageIO
					.read(Alien.class.getResource("/images/alien.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		alienWidth = alienImage.getWidth();
		alienHeight = alienImage.getHeight();
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
		super(alienImage, x, -alienHeight / 2, mY);
		mX = (int) (Math.random() * 6) + 1;
		if (Math.random() <= 0.5) {
			mX *= -1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desertBlasters_part5_collisionLogic_lifeCycle.Projectile#move()
	 */
	@Override
	public void move() {
		x += mX;
		y += mY;
		leftEdge = x - image.getWidth() / 2;
		rightEdge = x + image.getWidth() / 2;
		topEdge = y - image.getHeight() / 2;
		bottomEdge = y + image.getHeight() / 2;

		if (leftEdge < 0 || rightEdge > Main.screenWidth) {
			mX *= -1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * desertBlasters_part5_collisionLogic_lifeCycle.Projectile#draw(java.awt.
	 * Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(alienImage, leftEdge, topEdge, null);
		if (hasCollided) {
			g.drawImage(Projectile.explosion, x - Projectile.explosionWidth / 2,
					y - Projectile.explosionHeight / 2, null);
		} else {
			shootLaser();
		}
	}

	/**
	 * Shoots a laser 3% of the time.
	 */
	public void shootLaser() {
		// The y - 10 is to distance the laser from the alien, so the alien
		// does not touch the laser upon launching and explode immediately.
		if (Math.random() <= 0.03) {
			LaserManager.addLaser(new Laser(x, y + 10 + alienHeight / 2, 7));
		}
	}
}