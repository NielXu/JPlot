package histogram.trend;

import java.awt.Color;

/**
 * Trend represent the trend of one single data on the trendgraph and each
 * trend can have different color.
 * @author Daniel Xu
 *
 */
public class Trend {
	
	/**Color**/
	private Color c;
	
	/**Values**/
	private double[] val;
	
	/**Name**/
	private String name;

	/**
	 * Construct the Trend with given color and values. The length
	 * of the value array should be equal to the length of
	 * <code>Config.xunit</code>
	 * @param name Name of the data
	 * @param c The color represents the Trend
	 * @param val Values of the trend, start from left to right
	 */
	public Trend(String name, Color c, double...val) {
		this.c = c;
		this.val = val;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Get the color of the trend line
	 * @return Color of the trend line
	 */
	public Color getColor() {
		return c;
	}
	
	/**
	 * Get the values of the trend line
	 * @return Values of the trend line
	 */
	public double[] getVal() {
		return val;
	}
}
