package grapher.ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import grapher.Config;
import grapher.expression.Expression;
import grapher.util.Buffer;
import grapher.util.Point;

/**
 * Provide window for graphing. The window is not resizable
 * and can only be modified programmatically
 * @author danielxu
 *
 */
public class GraphWindow{

	/**The image that saves Graphics**/
	private BufferedImage img;
	
	/**Jframe window**/
	private JFrame frame;
	
	/**The GraphPanel that contains the graph of the function**/
	private GraphPanel panel;
	
	/**List of expressions**/
	private List<Expression> expressions;
	/**List of points**/
	private List<Buffer> points;
	
	/**Configuration**/
	private Config config;
	
	
	/**
	 * Construct the window and apply configuration on it
	 * @param config The Config object
	 */
	public GraphWindow(Config config){
		frame = new JFrame(config.TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		expressions = new ArrayList<Expression>();
		points = new ArrayList<Buffer>();
		this.config = config;
	}
	
	/**
	 * Buffer the Expression, store them in the List and
	 * evaluate the points behind the scene.
	 * @param exp The Expression object
	 */
	public void buffer_exp(Expression exp){
		// Evaluate points
		exp.getPoints();
		expressions.add(exp);
	}
	
	/**
	 * Buffer the points, store points in the List and draw
	 * on the graph when all the points had been added.
	 * @param points Array of points
	 */
	public void buffer_pts(Point[] points){
		this.points.add(new Buffer(points, config, null));
	}
	
	/**
	 * Buffer the points, store points in the List and draw
	 * on the graph when all the points had been added. Can
	 * also customize the point color
	 * @param points Array of points
	 * @param c The color of the points
	 */
	public void buffer_pts(Point[] points, Color c){
		this.points.add(new Buffer(points, config, c));
	}
	
	/**
	 * Show up the window, by default, the window is invisible
	 */
	public void show(){
		panel = new GraphPanel(points, expressions, config);
		frame.add(panel);
		frame.pack();
		if(config.graph_location_x == -1 && config.graph_location_y == -1) frame.setLocationRelativeTo(null);
		else frame.setLocation(config.graph_location_x, config.graph_location_y);
		frame.setVisible(true);
	}
	
	/**
	 * Get the image that saves everything painted on the graph
	 * @return Image
	 */
	public BufferedImage get_img() {
		if(img == null) {
			img = new BufferedImage(config.size, config.size, BufferedImage.TYPE_INT_RGB);
			panel.paint(img.createGraphics());
		}
		return img;
	}
	
}
