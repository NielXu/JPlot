package histogram.ui;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import histogram.Config;
import histogram.Section;

/**
 * Provide window for histogram, the window is not resizable once
 * it was created. However, the size of the window can be modified
 * in {@link histogram.Config}
 * @author Daniel Xu
 *
 */
public class HistogramWindow {

	/**The image that saves Graphics**/
	private BufferedImage img;
	
	/**JFrame window**/
	protected JFrame frame;
	
	/**The configuration**/
	protected Config config;
	
	/**The Jpanel that contains the graph**/
	protected HistogramPanel histogrampanel;
	
	/**index of vertical bar**/
	private int index;
	
	/**Array that contains all the vertical bars**/
	private Section[] sections;
	
	/**
	 * Construct histogram window and apply configuration
	 * @param config Configuration
	 */
	public HistogramWindow(Config config) {
		frame = new JFrame(config.TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		this.config = config;
		index = 0;
		sections = new Section[config.xunit.length];	// static length, for future exception mangement
	}	
	
	/**
	 * Add a vertical bar to the histogram. Please notice
	 * the amount of bars since it cannot be greater than number
	 * of x units
	 * @param b Vertical bar
	 */
	public void addSection(Section s) {
		sections[index] = s;
		index ++;
	}
	
	/**
	 * Get the image that saves everything painted on the graph
	 * @return Image
	 */
	public BufferedImage get_img() {
		if(img == null) {
			img = new BufferedImage(config.width, config.height, BufferedImage.TYPE_INT_RGB);
			histogrampanel.paint(img.createGraphics());
		}
		return img;
	}
	
	/**
	 * Show up the histogram on window, default is invisible
	 */
	public void show() {
		histogrampanel = new HistogramPanel(config, sections);
		frame.add(histogrampanel);
		frame.pack();
		if(config.graph_location_x == -1 && config.graph_location_y == -1) frame.setLocationRelativeTo(null);
		else frame.setLocation(config.graph_location_x, config.graph_location_y);
		frame.setVisible(true);
	}
}
