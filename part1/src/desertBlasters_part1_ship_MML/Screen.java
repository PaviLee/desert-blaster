package desertBlasters_part1_ship_MML;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A specialized JPanel that allows the user to get its graphics. With graphics,
 * the user can draw onto the Screen.
 * 
 * @author Rissa Li
 * @version July 16, 2020
 */
public class Screen extends JPanel {

	private static final long serialVersionUID = -7577759854950579746L;
	private static final int transparent = 0x00000000;

	private JFrame frame;
	private BufferedImage backgroundImage;
	private BufferedImage screenImage;
	private Graphics screenGraphics;

	/**
	 * Creates a Screen.
	 * 
	 * @param width
	 *            int width of Screen
	 * @param height
	 *            int height of Screen
	 */
	public Screen(int width, int height) {
		super();

		try {
			backgroundImage = ImageIO
					.read(getClass().getResource("/images/background.png"));
			backgroundImage = resize(backgroundImage, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(0, 0, 0, 0); // Width and height irrelevant
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		setPreferredSize(new Dimension(width, height));
		frame.add(this);
		frame.pack();
		frame.setVisible(true);

		screenImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		screenGraphics = screenImage.getGraphics();
		((Graphics2D) screenGraphics).setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	/**
	 * Returns a resized version of the inputed image.
	 * 
	 * @param img
	 *            BufferedImage to resize
	 * @param width
	 *            new width
	 * @param height
	 *            new height
	 * @return a resized BufferedImage.
	 */
	private static BufferedImage resize(BufferedImage img, int width,
			int height) {
		Image temp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	/**
	 * Returns the JFrame.
	 * 
	 * @return JFrame of the Screen.
	 */
	public JFrame getJFrame() {
		return frame;
	}

	/**
	 * Returns graphics for the Screen.
	 * 
	 * @return graphics for the Screen.
	 */
	public Graphics getScreenGraphics() {
		return screenGraphics;
	}

	/**
	 * Clears the Screen.
	 */
	public void clearScreen() {
		int row, col;
		for (col = 0; col < screenImage.getWidth(); col++) {
			for (row = 0; row < screenImage.getHeight(); row++) {
				screenImage.setRGB(col, row, transparent);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(screenImage, 0, 0, this);
	}
}