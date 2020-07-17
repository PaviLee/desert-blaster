package desertBlasters_ship_MML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Represents a ship.
 * 
 * @author Rissa Li
 * @version July 16, 2020
 */
public class Ship implements MouseMotionListener {

	private static final int SHIP_WIDTH = 50;
	private static final int SHIP_HEIGHT = 40;

	private int x, y;

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
		g.drawRect(x - SHIP_WIDTH / 2, y - SHIP_HEIGHT / 2, SHIP_WIDTH, SHIP_HEIGHT);
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

		checkXBounds();
		checkYBounds();
	}

	/**
	 * Checks if the Ship's x coordinate is outside the boundaries of the Screen. If
	 * it leaves the Screen at the left, it moves the Ship back to the left edge of
	 * the Screen. If it leaves the Screen at the right, it moves the Ship back to
	 * the right edge of the Screen.
	 */
	private void checkXBounds() {
		if (x - SHIP_WIDTH / 2 < 0) {
			x = SHIP_WIDTH / 2;
		} else if (x + SHIP_WIDTH / 2 > Main.SCREEN_WIDTH) {
			x = Main.SCREEN_WIDTH - SHIP_WIDTH / 2;
		}
	}

	/**
	 * Checks if the Ship's y coordinate is outside the boundaries of the Screen. If
	 * it leaves the Screen at the top, it moves the Ship back to the top edge of
	 * the Screen. If it leaves the Screen at the bottom, it moves the Ship back to
	 * the bottom edge of the Screen.
	 */
	private void checkYBounds() {
		if (y - SHIP_HEIGHT / 2 < 0) {
			y = SHIP_HEIGHT / 2;
		} else if (y + SHIP_HEIGHT / 2 > Main.SCREEN_HEIGHT) {
			y = Main.SCREEN_HEIGHT - SHIP_HEIGHT / 2;
		}
	}
}
