package histogram.ui.components;

import java.awt.Graphics;

import histogram.Config;

/**
 * HistogramComponent should be implemented by all components that added
 * to the HistogramPanel. The layers of component depend on the order that they are being added. 
 * The first component that being added will be at the most bottom layer, the last will be on the top.
 * @author Daniel Xu
 *
 */
public abstract class HistogramComponent {

	/**Configuration**/
	protected Config config;
	
	public HistogramComponent(Config config) {
		this.config = config;
	}
	
	/**
	 * Render the component on the Panel
	 * @param g Graphics g
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Get the starting point's x axis and y axis in an array.
	 * The axis value is in pixel format 
	 * @return array that contains x,y axis of start point
	 */
	protected int[] starting() {
		return new int[] {100, config.height-100};
	}
	
	/**
	 * Get the ending point's axis of x axis in an array
	 * The axis value is in pixel format 
	 * @return array that contains x,y axis of the x axis
	 */
	protected int[] end_x() {
		return new int[] {config.width - 75, config.height-100};
	}
	
	/**
	 * Get the ending point's axis of y axis in an array
	 * The axis value is in pixel format 
	 * @return array that contains x,y axis of the y axis
	 */
	protected int[] end_y() {
		return new int[] {100, 100};
	}
}
