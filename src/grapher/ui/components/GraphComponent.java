package grapher.ui.components;

import java.awt.Graphics;
import java.util.List;

import grapher.Config;
import grapher.expression.Expression;
import grapher.util.Buffer;

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
	protected int unit;
	/**Ratio between x,y and pixels**/
	protected int ratio;
	/**Origin x,y**/
	protected int origin_x, origin_y;
	
	public GraphComponent(Config config) {
		this.config = config;
		init();
	}
	
	// Init some of the important vars
	private void init() {
		unit = config.max_unit - config.min_unit;
		ratio = config.size / unit;
		origin_x = -config.min_unit * ratio;
		origin_y = config.size - origin_x;
	}
	
	/**
	 * Translate x,y values in axis to pixels
	 * @param x x value
	 * @param y y value
	 * @return An array that contains {x,y} in pixels
	 */
	protected final double[] translate(double x, double y){
		return new double[]{x*ratio, -y*ratio};
	}
	
	/**
	 * Translate pixels to x,y values in axis
	 * @param x x value
	 * @param y y value
	 * @return An array that contains {x,y} in axis
	 */
	protected final double[] re_translate(double x, double y) {
		return new double[] {x/ratio + config.min_unit, -y/ratio + config.max_unit};
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
