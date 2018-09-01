package grapher.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import grapher.Config;
import grapher.ui.components.AxisNumbersComponent;
import grapher.ui.components.CursorComponent;
import grapher.ui.components.FunctionComponent;
import grapher.ui.components.GraphComponent;
import grapher.ui.components.LayoutComponent;
import grapher.ui.components.PointComponent;
import grapher.ui.components.listener.MotionListener;
import grapher.util.Buffer;
import grapher.util.Expression;

/**
 * The GraphPanel is the JPanel that responsible for rendering
 * @author danielxu
 *
 */
public class GraphPanel extends JPanel{
	
	/**The compoennts on the graph**/
	private List<GraphComponent> components;
	
	/**Configuration**/
	private Config config;

	/**
	 * Construct the graphpanel, all the rendering are done here.
	 * @param points The points that rendered on screen
	 * @param expressions The funtions that rendered on screen
	 * @param config Configuration
	 */
	public GraphPanel(List<Buffer> points, List<Expression> expressions, Config config){
		super();
		setPreferredSize(new Dimension(config.width, config.height));
		this.config = config;
		components = new ArrayList<GraphComponent>();
		components.add(new LayoutComponent(config));
		components.add(new AxisNumbersComponent(config));
		components.add(new FunctionComponent(config).add_exp(expressions));
		components.add(new PointComponent(config).add_pts(points));
		// Cursor component is special since it requires motion listener
		CursorComponent cursorCompo = new CursorComponent(config);
		addMouseMotionListener(new MotionListener(this, cursorCompo));
		components.add(cursorCompo);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(config.high_quality) {
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
		// Background color rendering
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.width, config.height);
		// Render components
		for(GraphComponent c : components) {
			c.render(g);
		}
	}
}