package trend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import common.AbstractGraphTool;
import common.RenderPanel;
import trend.ui.TrendPanel;

/**
 * TrendGraph is a graphing tool that shows how one or more data changes over
 * time.
 * 
 * @author danielxu
 *
 */
public class TrendGraph extends AbstractGraphTool {

    private RenderPanel panel;

    private List<Trend> trends;

    private Config config;

    /**
     * Construct the trend graph with default configuration
     * 
     * @param config Configuration
     */
    public TrendGraph() {
	this(new Config());
    }

    /**
     * Construct the trend graph with custom configuration
     * 
     * @param config Configuration
     */
    public TrendGraph(Config config) {
	super(config);
	this.config = config;
	trends = new ArrayList<Trend>();
    }

    /**
     * Add one or more {@link trend.Trend} to the trend graph.
     * 
     * @param trends Array that contains the trends
     */
    public void add_trend(Trend... trends) {
	this.trends.addAll(Arrays.asList(trends));
    }

    @Override
    protected JPanel getGraphPanel() {
	if (panel == null) {
	    panel = new TrendPanel(config, trends);
	}
	return panel;
    }

}
