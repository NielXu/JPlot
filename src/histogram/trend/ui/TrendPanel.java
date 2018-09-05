package histogram.trend.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import histogram.Config;
import histogram.trend.Trend;
import histogram.ui.components.HistogramComponent;
import histogram.ui.components.LayoutComponent;

/**
 * JPanel that contains rendering contents
 * @author Daniel Xu
 *
 */
public class TrendPanel extends JPanel{

	private Config config;
	
	private List<HistogramComponent> components;
	
	public TrendPanel(Config config, List<Trend> trends) {
		super();
		this.config = config;
		setPreferredSize(new Dimension(config.width, config.height));
		components = new ArrayList<HistogramComponent>();
		components.add(new LayoutComponent(config));
		components.add(new TrendComponent(config).addTrend(trends));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Render background
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.width, config.height);
		// Render components
		for(HistogramComponent c : components) {
			c.render(g);
		}
	}
	
}
