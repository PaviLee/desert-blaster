package desertBlasters_part2_projectiles;

import java.awt.Graphics;
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
public class Ship implements MouseMotionListener {

	public static BufferedImage shipImage;
	public static int shipWidth;
	public static int shipHeight;

	public int x;
	public int y;
	public int leftEdge;
	public int rightEdge;
	public int topEdge;
	public int bottomEdge;

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
	 * Draws the Ship using graphics.
	 * 
	 * @param g
	 *            given Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(shipImage, leftEdge, topEdge, null);
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
	public void checkBounds() {
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
}