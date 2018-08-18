package histogram;

import histogram.ui.HistogramWindow;

public class Histogram {

	/**Configuration**/
	private Config config;
	
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
		this.config = config;
	}
	
	/**
	 * Show up the histogram, by default, it is invisible
	 */
	public void show() {
		histogram.show();
	}
}
