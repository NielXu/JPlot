package grapher;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import common.AbstractGraphTool;
import grapher.exceptions.SizeOutOfRangeException;
import grapher.ui.GraphPanel;
import grapher.util.Buffer;
import grapher.util.Expression;
import grapher.util.Point;
import util.ExceptionHandler;

/**
 * The Grapher is a tool that shows function on the screen.
 * @author danielxu
 *
 */
public class Grapher extends AbstractGraphTool{
	
	private List<Buffer> points_buffer;
	private List<Expression> expressions;
	private JPanel graphPanel;
	
	/**Configuration**/
	private Config config;
	
	/**
	 * Construct grapher with default configuration
	 */
	public Grapher(){
		this(new Config());
	}
	
	/**
	 * Construct grapher with custom configuration
	 * @param config The Config object
	 */
	public Grapher(Config config){
		super(config);
		if(ExceptionHandler.isnull(config)) {
			throw new NullPointerException("Configuration cannot be null");
		}
		this.config = config;
		points_buffer = new ArrayList<Buffer>();
		expressions = new ArrayList<Expression>();
	}
	
	/**
	 * Add one or more expressions to the graph. Each expression <b>can
	 * only be put in one graph</b>. Adding one expression to multiple
	 * graphs may result rendering error.
	 * @param exp Expression array
	 */
	public void add_exp(Expression...exp) {
		int check_result = ExceptionHandler.isnull(exp);
		if(check_result == ExceptionHandler.NULL_ARRAY) {
			throw new NullPointerException("Expressions array cannot be null");
		}
		else if(check_result != ExceptionHandler.VALID_ARRAY) {
			throw new NullPointerException("Expression at index " + check_result + " cannot be null");
		}
		expressions.addAll(Arrays.asList(exp));
	}
	
	/**
	 * Add one or more points on the graph. The points will be discrete and
	 * will not be connected together. However, regression is
	 * available with proper configuration.{@link grapher.Config}
	 * @param points The array that contains points on the graph {@link grapher.util.Point}
	 */
	public void add_pts(Point... points){
		add_pts(config.point_color, config.point_size, points);
	}
	
	/**
	 * Add one or more points on the graph with custom size. The points will be discrete and
	 * will not be connected together. However, regression is
	 * available with proper configuration.{@link grapher.Config}
	 * @param size The size of the point, minimum value should be 1
	 * @param points The array that contains points on the graph {@link grapher.util.Point}
	 */
	public void add_pts(int size, Point... points) {
		add_pts(config.point_color, config.point_size, points);
	}
	
	/**
	 * Add one or more points on the graph with custom color. The points will be discrete and
	 * will not be connected together. However, regression is
	 * available with proper configuration.{@link grapher.Config}
	 * @param points The array that contains points on the graph {@link grapher.util.Point}
	 * @param c Color of the points
	 */
	public void add_pts(Color c, Point... points){
		add_pts(c, config.point_size, points);
	}
	
	/**
	 * Add one or more points on the graph with custom size and color. The points will be discrete and
	 * will not be connected together. However, regression is
	 * available with proper configuration.{@link grapher.Config}
	 * @param c The color of the points
	 * @param size The size of the points
	 * @param points The array that contains points on the graph {@link grapher.util.Point}
	 */
	public void add_pts(Color c, int size, Point... points) {
		if(ExceptionHandler.isnull(c)) {
			throw new NullPointerException("Color cannot be null");
		}
		if(ExceptionHandler.outrange(size, 1, Integer.MAX_VALUE)) {
			throw new SizeOutOfRangeException("Size of the point must be greater than 0");
		}
		int check_result = ExceptionHandler.isnull(points);
		if(check_result == ExceptionHandler.NULL_ARRAY) {
			throw new NullPointerException("Points array cannot be null");
		}
		else if(check_result != ExceptionHandler.VALID_ARRAY) {
			throw new NullPointerException("Point at index " + check_result + " cannot be null");
		}
		points_buffer.add(new Buffer(points, c, size));
	}

	@Override
	protected JPanel getGraphPanel() {
		if(graphPanel == null) {
			graphPanel = new GraphPanel(points_buffer, expressions, config);
		}
		return graphPanel;
	}
}
