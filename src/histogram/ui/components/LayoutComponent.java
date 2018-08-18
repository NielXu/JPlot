package histogram.ui.components;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

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
	}
	
	private void render_title(Graphics g) {
		Rectangle rect = new Rectangle(config.width/2-50, 20, 100, 50);
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(config.title_font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(config.title)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Draw the String
	    g.setFont(config.title_font);
	    g.setColor(config.title_color);
	    g.drawString(config.title, x, y);
	}
	
	private void render_xlabel(Graphics g) {
		Rectangle rect = new Rectangle(config.width/2-10, config.height - 75, 20, 50);
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(config.xlabel_font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(config.xlabel)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Draw the String
	    g.setFont(config.xlabel_font);
	    g.setColor(config.xlabel_color);
	    g.drawString(config.xlabel, x, y);
	}
	
	private void render_ylabel(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform aff = g2d.getTransform();
		Rectangle rect = new Rectangle(25, config.height/2-100, 100, 50);
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
		int[] start = super.starting();
		int[] end_x = super.end_x();
		int[] end_y = super.end_y();
		// Draw x axis
		g.drawLine(start[0], start[1], end_x[0], end_x[1]);
		// Draw y axis
		g.drawLine(start[0], start[1], end_y[0], end_y[1]);
	}
}
