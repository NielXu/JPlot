package trend.ui.components;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Path2D;
import java.util.List;

import histogram.Category;
import histogram.Config;
import histogram.ui.components.HistogramComponent;
import trend.Trend;

/**
 * TrendComponent is responsible for rendering trend lines
 * 
 * @author Daniel Xu
 *
 */
public class TrendComponent extends HistogramComponent {

    private List<Trend> trends;

    public TrendComponent(Config config) {
	super(config);
    }

    @Override
    public HistogramComponent addTrend(List<Trend> trends) {
	this.trends = trends;
	return this;
    }

    @Override
    public void render(Graphics g) {
	for (int i = 0; i < trends.size(); i++) {
	    renderTrend(g, trends.get(i));
	}
    }

    private void renderTrend(Graphics g, Trend t) {
	Category c = t.getCategory();
	double[] vals = t.getVal();
	Path2D path = new Path2D.Double();
	for (int i = 0; i < vals.length; i++) {
	    double val = vals[i];
	    double x = (starting[0] + xscale / 2) + i * xscale;
	    double y = starting[1] - val * yscale;
	    int tness = config.trend_thickness;
	    if (config.show_trenddot) {
		g.setColor(c.getColor());
		g.fillOval((int) x - tness, (int) y - tness, tness * 2, tness * 2);
	    }
	    if (i == 0)
		path.moveTo(x, y);
	    else
		path.lineTo(x, y);
	}
	Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(c.getColor());
	Stroke origin = g2d.getStroke();
	g2d.setStroke(new BasicStroke(config.trend_thickness));
	g2d.draw(path);
	g2d.setStroke(origin);
	if (config.show_trendnumber) {
	    for (int i = 0; i < vals.length; i++) {
		double val = vals[i];
		double y = starting[1] - val * yscale;
		Rectangle r = new Rectangle((int) (starting[0] + i * xscale), (int) (y) - 35, (int) xscale, 30);
		String text = config.barnumber_decimal.format(val * (config.yunit[1] - config.yunit[0]));
		super.renderlabel(g, r, config.barnumber_font, text, config.barnumber_color);
	    }
	}
    }

}
