package desertBlasters_part7_encapsulation;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a ship.
 * 
 * @author Rissa Li
 * @version July 16, 2020
 */
public class Ship implements MouseMotionListener, KeyListener {

	public static final int shipWidth;
	public static final int shipHeight;

	private static BufferedImage shipImage;

	private int x;
	private int y;
	private int leftEdge;
	private int rightEdge;
	private int topEdge;
	private int bottomEdge;
	private boolean hasCollided;

	static {
		try {
			shipImage = ImageIO
					.read(Ship.class.getResource("/images/ship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		shipWidth = shipImage.getWidth();
		shipHeight = shipImage.getHeight();
	}

	/**
	 * Creates a ship.
	 * 
	 * @param x
	 *            starting x coordinate
	 * @param y
	 *            starting y coordinate
	 */
	public Ship(int x, int y) {
		this.x = x;
		this.y = y;
		leftEdge = x - shipImage.getWidth() / 2;
		rightEdge = x + shipImage.getWidth() / 2;
		topEdge = y - shipImage.getHeight() / 2;
		bottomEdge = y + shipImage.getHeight() / 2;
	}

	/**
	 * Returns leftEdge.
	 * 
	 * @return leftEdge.
	 */
	public int getLeftEdge() {
		return leftEdge;
	}

	/**
	 * Returns rightEdge.
	 * 
	 * @return rightEdge.
	 */
	public int getRightEdge() {
		return rightEdge;
	}

	/**
	 * Returns topEdge.
	 * 
	 * @return topEdge.
	 */
	public int getTopEdge() {
		return topEdge;
	}

	/**
	 * Returns bottomEdge.
	 * 
	 * @return bottomEdge.
	 */
	public int getBottomEdge() {
		return bottomEdge;
	}

	/**
	 * Sets hasCollided to inputed boolean.
	 * 
	 * @param hasCollided
	 *            new hasCollided value
	 */
	public void setHasCollided(boolean hasCollided) {
		this.hasCollided = hasCollided;
	}

	/**
	 * Draws the Ship using graphics.
	 * 
	 * @param g
	 *            given Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(shipImage, leftEdge, topEdge, null);

		if (hasCollided) {
			g.drawImage(Projectile.getExplosionImage(),
					x - Projectile.explosionWidth / 2,
					y - Projectile.explosionHeight / 2, null);
			Main.setGameOver(true);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.
	 * MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		checkBounds();

		leftEdge = x - shipImage.getWidth() / 2;
		rightEdge = x + shipImage.getWidth() / 2;
		topEdge = y - shipImage.getHeight() / 2;
		bottomEdge = y + shipImage.getHeight() / 2;
	}

	/**
	 * Checks if the Ship is within the boundaries of the Screen. If not, moves
	 * the Ship back onto it.
	 */
	private void checkBounds() {
		if (x - shipWidth / 2 < 0) {
			x = shipWidth / 2;
		} else if (x + shipWidth / 2 > Main.screenWidth) {
			x = Main.screenWidth - shipWidth / 2;
		}

		if (y - shipHeight / 2 < 0) {
			y = shipHeight / 2;
		} else if (y + shipHeight / 2 > Main.screenHeight) {
			y = Main.screenHeight - shipHeight / 2;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			shootLaser();
		}
	}

	/**
	 * Shoots a laser.
	 */
	private void shootLaser() {
		// The y - 40 is to distance the laser from the ship, so the ship
		// does not touch the laser upon launching and explode immediately.
		LaserManager.addLaser(new Laser(x,
				y - 40 - shipHeight / 2 - Laser.laserHeight / 2, -10));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}
}