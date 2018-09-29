package trend.ui;

import java.util.List;

import common.RenderPanel;
import histogram.ui.components.LayoutComponent;
import trend.Config;
import trend.Trend;
import trend.ui.components.TrendComponent;

/**
 * JPanel that contains rendering contents
 * @author Daniel Xu
 *
 */
public class TrendPanel extends RenderPanel{
		
	public TrendPanel(Config config, List<Trend> trends) {
		super(config);
		super.addRenderable(new LayoutComponent(config));
		super.addRenderable(new TrendComponent(config).addTrend(trends));
	}
	
}
