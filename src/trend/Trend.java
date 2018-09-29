package trend;

import histogram.Category;

/**
 * Trend represent the trend of one single data on the trendgraph and each
 * trend can have different color.
 * @author Daniel Xu
 *
 */
public class Trend {
	
	/**Category that this trend belongs to**/
	private Category category;
	
	/**Values**/
	private double[] val;

	/**
	 * Construct the Trend with given category that this trend belongs to. 
	 * The length of the value array should be equal to the length of
	 * <code>Config.xunit</code>
	 * @category The category that this trend belongs to
	 * @param val Values of the trend, start from left to right
	 */
	public Trend(Category c, double...val) {
		this.category = c;
		this.val = val;
	}
	
	/**
	 * Get the values of the trend line
	 * @return Values of the trend line
	 */
	public double[] getVal() {
		return val;
	}
	
	/**
	 * Get the category of this trend
	 * @return category of this trend
	 */
	public Category getCategory() {
		return category;
	}
}
