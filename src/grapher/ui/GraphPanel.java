package grapher.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import grapher.Config;
import grapher.expression.Expression;
import grapher.ui.components.*;
import grapher.ui.components.listener.MotionListener;
import grapher.util.Point;

/**
 * The GraphPanel is the JPanel that responsible for rendering
 * @author danielxu
 *
 */
public class GraphPanel extends JPanel{
	
	/**The compoennts on the graph**/
	private List<GraphComponent> components;
	
	/**Default serial id**/
	private static final long serialVersionUID = 1L;
	
	/**Configuration**/
	private Config config;

	/**
	 * Construct the graphpanel, all the rendering are done here.
	 * @param points The points that rendered on screen
	 * @param expressions The funtions that rendered on screen
	 * @param config Configuration
	 */
	public GraphPanel(List<Point> points, List<Expression> expressions, Config config){
		super();
		setPreferredSize(new Dimension(config.size, config.size));
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
		// Background color rendering
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.size, config.size);
		// Render components
		for(GraphComponent c : components) {
			c.render(g);
		}
	}
}