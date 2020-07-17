package desertBlasters_ship_MML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ship implements MouseMotionListener {

	private static final int SHIP_WIDTH = 50;
	private static final int SHIP_HEIGHT = 40;

	private int x, y;

	public Ship(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(x - SHIP_WIDTH / 2, y - SHIP_HEIGHT / 2, SHIP_WIDTH, SHIP_HEIGHT);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		checkXBounds();
		checkYBounds();
	}

	private void checkXBounds() {
		if (x - SHIP_WIDTH / 2 < 0) {
			x = SHIP_WIDTH / 2;
		} else if (x + SHIP_WIDTH / 2 > Main.SCREEN_WIDTH) {
			x = Main.SCREEN_WIDTH - SHIP_WIDTH / 2;
		}
	}

	private void checkYBounds() {
		if (y - SHIP_HEIGHT / 2 < 0) {
			y = SHIP_HEIGHT / 2;
		} else if (y + SHIP_HEIGHT / 2 > Main.SCREEN_HEIGHT) {
			y = Main.SCREEN_HEIGHT - SHIP_HEIGHT / 2;
		}
	}
}
