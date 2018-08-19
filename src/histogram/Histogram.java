package histogram;

import histogram.ui.HistogramWindow;

/**
 * A histogram is an accurate representation of the distribution of numerical data.
 * User can customize the histogram and create their own graph.
 * @author Daniel Xu
 *
 */
public class Histogram {
	
	/**histogram window**/
	private HistogramWindow histogram;
	
	/**
	 * Construct a new histogram with default configuration
	 */
	public Histogram() {
		this(new Config());
	}
	
	/**
	 * Construct a new histogram with custom configuration
	 * @param config Configuration
	 */
	public Histogram(Config config) {
		histogram = new HistogramWindow(config);
	}
	
	/**
	 * Add one section on the graph. Please notice that
	 * the number os sections cannot be greater than the
	 * number of x units
	 * @param s A section {@link histogram.Section}
	 */
	public void addSection(Section s) {
		histogram.addSection(s);
	}
	
	/**
	 * Show up the histogram, by default, it is invisible
	 */
	public void show() {
		histogram.show();
	}
}
