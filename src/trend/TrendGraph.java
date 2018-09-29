package trend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import common.AbstractGraphTool;
import common.RenderPanel;
import trend.ui.TrendPanel;

public class TrendGraph extends AbstractGraphTool{
	
	private RenderPanel panel;
	
	private List<Trend> trends;
	
	private Config config;

	public TrendGraph() {
		this(new Config());
	}
	
	public TrendGraph(Config config) {
		super(config);
		this.config = config;
		trends = new ArrayList<Trend>();
	}
	
	public void add_trend(Trend...trends) {
		this.trends.addAll(Arrays.asList(trends));
	}

	@Override
	protected JPanel getGraphPanel() {
		if(panel == null) {
			panel = new TrendPanel(config, trends);
		}
		return panel;
	}

}
