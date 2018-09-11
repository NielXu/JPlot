package common;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * RenderPanel extends JPanel, which means it can be used as an
 * component in JFrame. The task of RenderPanel is to render all
 * renderable objects that store in the list on the JPanel by
 * overriding the {@link #paintComponent(Graphics)} method.
 * There is also a method {@link #addRenderable(Renderable)} that
 * can add renderable objects so that they can be rendered. The render
 * list is empty initially and if there is nothing being added, only
 * the background will be shown. The layers of the renderable objects
 * depend on the orders that they were being added. The first added renderable
 * object will be at the bottom and the last will be on top.
 * @author Daniel Xu
 *
 */
public class RenderPanel extends JPanel{
	
	/**Configuration**/
	protected BaseConfig config;
	
	/**List of renderable objects**/
	protected List<Renderable> renderlist;
	
	/**
	 * Construct the RenderPanel by providing {@link common.BaseConfig}.
	 * In the constructor, the preferredsize will be set accordingly and
	 * also an arraylist that contains renderable objects is initialized
	 * @param config Base configuration {@link common.BaseConfig}
	 */
	public RenderPanel(BaseConfig config) {
		super();
		this.config = config;
		setPreferredSize(new Dimension(config.width, config.height));
		renderlist = new ArrayList<Renderable>();
	}
	
	/**
	 * Add a renderable object to the list in order to render it on screen.
	 * The layers of the renderable objects depend on the orders that they
	 * were being added. The first added renderable object will be at the
	 * bottom and the last will be on top
	 * @param o Renderable object: {@link common.Renderable}
	 */
	public void addRenderable(Renderable o) {
		renderlist.add(o);
	}
	
	/**
	 * Override the <code>paintComponent(Graphics)</code> method from the
	 * parent JPanel class to customize rendering part
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Set renderhint
		if(config.enableHighQuality()) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
			g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE); 
		}
		// Background
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.width, config.height);
		// Renderable objects rendering
		for(Renderable o : renderlist) {
			o.render(g);
		}
	}
	
}
