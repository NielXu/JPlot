package grapher.ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.List;

import grapher.Config;
import grapher.util.Buffer;
import grapher.util.Expression;
import grapher.util.InvalidPoint;
import grapher.util.Point;

/**
 * GraphComponent is the abstract parent class that every components should extends. It includes some
 * of the methods and variables that are ready to use and also some abstract methods that need to
 * be implemented. The layers of component depend on the order that they are being added. The first
 * component that being added will be at the most bottom layer, the last will be on the top.
 * @author Daniel Xu
 *
 */
public abstract class GraphComponent {

	/**The Grapher configuration**/
	protected Config config;
	
	/**The number of units for x-axis and y-axis**/
	protected int xunit, yunit;
	/**Ratio between x,y and pixels**/
	protected int xratio, yratio;
	/**Origin x,y**/
	protected int origin_x, origin_y;
	
	public GraphComponent(Config config) {
		this.config = config;
		init();
	}
	
	// Init some of the important vars
	private void init() {
		xunit = config.x_max - config.x_min;
		yunit = config.y_max - config.y_min;
		xratio = config.width / xunit;
		yratio = config.height / yunit;
		origin_x = -config.x_min * xratio;
		origin_y = config.height - (-config.y_min * yratio);
	}
	
	/**
	 * Translate x,y values in axis to pixels
	 * @param x x value
	 * @param y y value
	 * @return An array that contains {x,y} in pixels
	 */
	protected final double[] translate(double x, double y){
		return new double[]{x*xratio, -y*yratio};
	}
	
	/**
	 * Translate pixels to x,y values in axis
	 * @param x x value
	 * @param y y value
	 * @return An array that contains {x,y} in axis
	 */
	protected final double[] re_translate(double x, double y) {
		return new double[] {x/xratio + config.x_min, -y/yratio + config.y_max};
	}
	
	/**
	 * Transform the axis to the origin. That means the (0,0) on the graph
	 * will be the origin. However, it is necessary to reset the origin back
	 * since it will affect the following components' rendering.
	 * @param g The graphics object
	 */
	protected final void transform_to_origin(Graphics g) {
		g.translate(origin_x, origin_y);
	}
	
	/**
	 * Render a expression on the graph
	 * @param g Graphics
	 * @param e Expression {@link grapher.util.Expression}
	 */
	protected void render_expression(Graphics g, Expression e) {
		// Convert graphics to graphics2d
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		transform_to_origin(g2d);
		g2d.setColor(config.func_color); 
		// Iterate and render all points, connect them with Path
		Point[] exp_pts = e.getGraphPoints(config.x_min, config.x_max, config.density);
		Path2D path = new Path2D.Float();
		for(int j=0;j<exp_pts.length;j++){
			Point p = exp_pts[j];
			if(!(p instanceof InvalidPoint)) {
				double[] trans = translate(p.x, p.y);
				if(j==0) path.moveTo(trans[0], trans[1]);
				else path.lineTo(trans[0], trans[1]);
			}
		}
		g2d.setColor(e.getColor());
		g2d.draw(path);
		// Remember to reset origin back to normal
		g2d.setTransform(transform);
	}
	
	/**
	 * Add a list of expressions to the component. If necessary, some classes
	 * may override this method in order to get the list.
	 * @param l List of expressions
	 * @return Return the instance of itself
	 */
	public GraphComponent add_exp(List<Expression> l) {
		return this;
	}
	
	/**
	 * Add a list of points to the component. If necessary, some classes
	 * may override this method in order to get the list.
	 * @param l List of points
	 * @return Return the instance itself
	 */
	public GraphComponent add_pts(List<Buffer> l) {
		return this;
	}
	
	/**
	 * Render the component on the Panel
	 * @param g Graphics g
	 */
	public abstract void render(Graphics g);

}
