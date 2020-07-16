package desertBlasters_ship_MML;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A specialized JPanel that is used to display an image as its background.
 * 
 * @author Rissa Li
 * @version May 26, 2020
 *
 */
public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = -4623646467273651538L;

	private BufferedImage bImage;

	/**
	 * Creates a BackgroundPanel.
	 * 
	 * @param width
	 *            int width of BackgroundPanel
	 * @param height
	 *            int height of BackgroundPanel
	 */
	public BackgroundPanel(int width, int height) {
		super();
		try {
			bImage = ImageIO.read(getClass().getResource("/images/background.jpg"));
			bImage = resize(bImage, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	private static BufferedImage resize(BufferedImage img, int width, int height) {
		Image temp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bImage, 0, 0, this);
	}
}
