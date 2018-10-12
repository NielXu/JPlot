package piechart.ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import common.Renderable;
import piechart.Config;
import piechart.Sector;

/**
 * PieComponent should be implemented by all components that added to the pie
 * chart. The layers of component depend on the order that they are being added.
 * The first component that being added will be at the most bottom layer, the
 * last will be on the top.
 * 
 * @author Daniel Xu
 *
 */
public abstract class PieComponent implements Renderable {

    /** Configuration **/
    protected Config config;

    /** The title location **/
    protected int title_x, title_y;

    /** The chart location **/
    protected int chart_x, chart_y;

    /** The label location **/
    protected int label_x, label_y;

    /** The origin of the chart **/
    protected int origin_x, origin_y;

    /** Size of the chart **/
    protected int chart_size;

    /**
     * Construct the PieComponent with given config
     * 
     * @param config Configuration
     */
    public PieComponent(Config config) {
	this.config = config;
	init();
    }

    private void init() {
	title_x = 0;
	title_y = 15;
	chart_size = config.width * 2 / 3;
	chart_x = config.width / 2 - chart_size / 2;
	chart_y = title_y + 35;
	origin_x = config.width / 2;
	origin_y = chart_y + chart_size / 2;
    }

    /**
     * Render text at the center of rectangle
     * 
     * @param g    Graphics object
     * @param rect THe rectangle
     * @param font Text font
     * @param text Text
     * @param c    Color of the text
     */
    protected void renderlabel(Graphics g, Rectangle rect, Font font, String text, Color c) {
	// Get the FontMetrics
	FontMetrics metrics = g.getFontMetrics(font);
	// Determine the X coordinate for the text
	int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	// Determine the Y coordinate for the text (note we add the ascent, as in java
	// 2d 0 is top of the screen)
	int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	// Draw the String
	g.setFont(font);
	g.setColor(c);
	g.drawString(text, x, y);
    }

    /**
     * Add sectors to the pie chart
     * 
     * @param sector Sector {@link piechart.Sector}
     * @return PieComponent instance itself
     */
    public PieComponent addSector(List<Sector> sector) {
	return this;
    }

    /**
     * Render the component on the Panel
     * 
     * @param g Graphics g
     */
    public abstract void render(Graphics g);

}
