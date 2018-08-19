package histogram.ui.components;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import histogram.Config;

/**
 * LayoutComponent is usually the most bottom component, it is
 * responsible for rendering labels and axis.
 * @author Daniel Xu
 *
 */
public class LayoutComponent extends HistogramComponent{

	public LayoutComponent(Config config) {
		super(config);
	}
	
	@Override
	public void render(Graphics g) {
		render_title(g);
		render_xlabel(g);
		render_ylabel(g);
		render_axis(g);
		render_grid(g);
		render_unit_label(g);
	}
	
	private void render_title(Graphics g) {
		Rectangle rect = new Rectangle(config.width/2-50, 20, 100, 50);
		renderlabel(g, rect, config.title_font, config.title, config.title_color);
	}
	
	private void render_xlabel(Graphics g) {
		Rectangle rect = new Rectangle(config.width/2-10, config.height - 50, 20, 50);
		renderlabel(g, rect, config.xlabel_font, config.xlabel, config.xlabel_color);
	}
	
	private void render_ylabel(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform aff = g2d.getTransform();
		Rectangle rect = new Rectangle(25, config.height/2-135, 100, 50);
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(config.ylabel_font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(config.ylabel)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    AffineTransform at= AffineTransform.getRotateInstance(Math.toRadians(270),75,config.height/2-50);
	    g2d.transform(at);
	    g.drawString(config.ylabel, x, y);
	    g2d.setTransform(aff); // reset
	}
	
	private void render_axis(Graphics g) {
		g.setColor(config.axis_color);
		// Draw x axis
		g.drawLine(starting[0], starting[1], end_x[0], end_x[1]);
		// Draw y axis
		g.drawLine(starting[0], starting[1], end_y[0], end_y[1]);
	}
	
	private void render_grid(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(config.show_xgrid) {
			g2d.setColor(config.grid_color);
			for(int i=0;i<xunit.length;i++) {
				Shape line = new Line2D.Double(xunit[i], starting[1], xunit[i], end_y[1]);
				g2d.draw(line);
			}
			// Fill the right most grid
			Shape line = new Line2D.Double(xunit[xunit.length-1] + xscale, starting[1], 
										   xunit[xunit.length-1] + xscale , end_y[1]);
			g2d.draw(line);
		}
		if(config.show_ygrid) {
			for(int i=0;i<yunit.length;i++) {
				Shape line = new Line2D.Double(starting[0], yunit[i], end_x[0], yunit[i]);
				g2d.draw(line);
			}	
		}
	}
	
	private void render_unit_label(Graphics g) {
		if(config.show_units_label) {
			String[] xlabels = config.xunit;
			double[] ylabels = config.yunit;
			for(int i=0;i<xunit.length;i++) {
				Rectangle rect = new Rectangle((int)xunit[i], starting[1] + 15, (int)xscale, 25);
				renderlabel(g, rect, config.xunit_font, xlabels[i], config.xunit_color);
			}
			for(int i=0;i<yunit.length;i++) {
				Rectangle rect = new Rectangle(starting[0] - 60, (int)yunit[i]-5, (int)yscale, 25);
				renderlabel(g, rect, config.yunit_font, String.valueOf(ylabels[yunit.length-1-i]), config.yunit_color);
			}
		}
	}
}
