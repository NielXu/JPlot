package histogram.ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import common.Renderable;
import histogram.Config;
import histogram.Section;
import trend.Trend;

/**
 * HistogramComponent should be implemented by all components that added
 * to the HistogramPanel. The layers of component depend on the order that they are being added. 
 * The first component that being added will be at the most bottom layer, the last will be on the top.
 * @author Daniel Xu
 *
 */
public abstract class HistogramComponent implements Renderable{

	/**Configuration**/
	protected Config config;
	
	/**x,y units**/
	protected double[] xunit, yunit;
	
	/**Scale of the graph**/
	protected double xscale, yscale;
	
	/**Starting point of the graph, ending point of x axis and ending point of y axis**/
	protected int[] starting, end_x, end_y;
	
	public HistogramComponent(Config config) {
		this.config = config;
		init();
	}
	
	// Initialize some important variables
	private void init() {
		xunit = new double[config.xunit.length];
		yunit = new double[config.yunit.length];
		int xrange = (config.width - 75) - 100;
		int yrange = (config.height - 100 - 100);
		xscale = xrange / xunit.length;
		yscale = yrange / yunit.length;
		for(int i=0;i<xunit.length;i++) {
			xunit[i] = 100 + i*xscale;
		}
		for(int i=0;i<yunit.length;i++) {
			yunit[i] = 100 + i*yscale;
		}
		starting = new int[] {100, config.height-100};
		end_x = new int[] {config.width - 75, config.height-100};
		end_y = new int[] {100, 100};
	}
	
	/**
	 * Add sections to the component
	 * @param section Section {@link histogram.Section}
	 * @return HistogramComponent instance itself
	 */
	public HistogramComponent addSection(List<Section> section) {
		return this;
	}
	
	/**
	 * Add trends to the component
	 * @param trend list of {@link trend.Trend}
	 * @return HistogramComponent instance itself
	 */
	public HistogramComponent addTrend(List<Trend> trend) {
		return this;
	}
	
	/**
	 * Render text at the center of rectangle
	 * @param g Graphics object
	 * @param rect THe rectangle
	 * @param font Text font
	 * @param text Text
	 * @param c Color of the text
	 */
	protected void renderlabel(Graphics g, Rectangle rect, Font font, String text, Color c) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Draw the String
	    g.setFont(font);
	    g.setColor(c);
	    g.drawString(text, x, y);
	}
	
	/**
	 * Render the component on the Panel
	 * @param g Graphics g
	 */
	public abstract void render(Graphics g);
}
