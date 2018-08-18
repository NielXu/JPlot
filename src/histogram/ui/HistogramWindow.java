package histogram.ui;

import javax.swing.JFrame;

import histogram.Config;

/**
 * Provide window for histogram, the window is not resizable once
 * it was created. However, the size of the window can be modified
 * in {@link histogram.Config}
 * @author Daniel Xu
 *
 */
public class HistogramWindow {

	/**JFrame window**/
	private JFrame frame;
	
	/**The configuration**/
	private Config config;
	
	/**The Jpanel that contains the graph**/
	private HistogramPanel histogrampanel;
	
	/**
	 * Construct histogram window and apply configuration
	 * @param config Configuration
	 */
	public HistogramWindow(Config config) {
		frame = new JFrame(config.TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		this.config = config;
	}
	
	/**
	 * Show up the histogram on window, default is invisible
	 */
	public void show() {
		histogrampanel = new HistogramPanel(config);
		frame.add(histogrampanel);
		frame.pack();
		if(config.graph_location_x == -1 && config.graph_location_y == -1) frame.setLocationRelativeTo(null);
		else frame.setLocation(config.graph_location_x, config.graph_location_y);
		frame.setVisible(true);
	}
}
