package histogram.trend;

import histogram.Config;
import histogram.trend.ui.TrendWindow;

/**
 * TrendGraph shows how the data changed in an time interval,
 * it is similar with histogram but it shows lines instead of bars
 * @author Daniel Xu
 *
 */
public class TrendGraph {

	/**Window with main panel**/
	private TrendWindow trend;
	
	/**
	 * Construct the TrendGraph with the default configuration
	 */
	public TrendGraph() {
		this(new Config());
	}
	
	/**
	 * Construct the TrendGraph with custom configuration, it
	 * shares the same <code>Config</code> with {@link histogram.Histogram}
	 * @param config Configuration {@link histogram.Config}
	 */
	public TrendGraph(Config config) {
		trend = new TrendWindow(config);
	}
	
	/**
	 * Add one or more trends to the TrendGraph
	 * @param trends {@link histogram.trend.Trend}
	 */
	public void add_trend(Trend...trends) {
		trend.add_trend(trends);
	}
	
	/**
	 * Show up the TrendGraph on screen, it is invisible by default
	 */
	public void show() {
		trend.show();
	}
	
}
