package desertBlasters_ship_MML;

import java.awt.Graphics;

public class Main {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 700;

	public static void main(String[] args) {

		Screen screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
		Graphics g = screen.getScreenGraphics();

		Ship ship = new Ship(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
		screen.addMouseMotionListener(ship);

		while (true) {
			screen.clearScreen();

			ship.draw(g);

			screen.repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
