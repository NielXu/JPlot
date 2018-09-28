package histogram.trend.ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import common.AbstractGraphTool;
import histogram.Config;
import histogram.trend.Trend;

/**
 * Provide window for trendgraph, inherits {@link histogram.ui.HistogramWindow}
 * @author Daniel Xu
 *
 */
public class TrendWindow extends AbstractGraphTool{
	
	private BufferedImage img;
	
	private JPanel trendPanel;

	private List<Trend> trends;
	
	public TrendWindow(Config config) {
		super(config);
		trends = new ArrayList<Trend>();
	}
	
	public void add_trend(Trend...trends) {
		this.trends.addAll(Arrays.asList(trends));
	}
	
	@Override
	public BufferedImage get_img() {
		if(img == null) {
			img = new BufferedImage(config.width, config.height, BufferedImage.TYPE_INT_RGB);
			trendPanel.paint(img.createGraphics());
		}
		return img;
	}
	
	@Override
	public void show() {
		trendPanel = new TrendPanel(config, trends);
		frame.add(trendPanel);
		frame.pack();
		if(config.graph_location_x == -1 && config.graph_location_y == -1) frame.setLocationRelativeTo(null);
		else frame.setLocation(config.graph_location_x, config.graph_location_y);
		frame.setVisible(true);
	}

}
