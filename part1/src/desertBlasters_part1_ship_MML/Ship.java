package desertBlasters_part1_ship_MML;

import java.awt.Color;
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

	public static BufferedImage image;
	public static int shipWidth;
	public static int shipHeight;

	public int x, y;

	static {
		try {
			image = ImageIO.read(Ship.class.getResource("/images/ship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		shipWidth = image.getWidth();
		shipHeight = image.getHeight();
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
	}

	/**
	 * Draws the Ship using graphics.
	 * 
	 * @param g
	 *            given Graphics
	 */
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawImage(image, x - shipWidth / 2, y - shipHeight / 2, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
}