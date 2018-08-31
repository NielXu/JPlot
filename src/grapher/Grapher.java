package grapher;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import grapher.ui.GraphWindow;
import grapher.util.Expression;
import grapher.util.Point;

/**
 * The Grapher is a tool that shows function on the screen.
 * @author danielxu
 *
 */
public class Grapher {

	/**The graph window**/
	private GraphWindow graph;
	
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
		graph = new GraphWindow(config);
	}
	
	/**
	 * Add one or more expressions to the graph
	 * @param exp Expression array
	 */
	public void add_exp(Expression...exp) {
		for(Expression e: exp) {
			graph.buffer_exp(e);
		}
	}
	
	/**
	 * Add one or more points on the graph. The points will be discrete and
	 * will not be connected together. However, regression is
	 * available with proper configuration.{@link grapher.Config}
	 * @param points The array that contains points on the graph {@link grapher.util.Point}
	 */
	public void add_pts(Point... points){
		graph.buffer_pts(points);
	}
	
	/**
	 * Add one or more points on the graph with custom color. The points will be discrete and
	 * will not be connected together. However, regression is
	 * available with proper configuration.{@link grapher.Config}
	 * @param points The array that contains points on the graph {@link grapher.util.Point}
	 * @param c Color of the points
	 */
	public void add_pts(Color c, Point... points){
		graph.buffer_pts(points, c);
	}
	
	/**
	 * Save the graph on the grapher as the given image type.
	 * This method only work after the show() method is called.
	 * @param name The name of the image file
	 * @param dir The directory that the image will be saved at
	 * @param type The image type, img, jpg or png
	 */
	public void save_img(String name, String dir, String type) {
		BufferedImage img = graph.get_img();
		try{
			File f = new File(dir + "\\" + name + "." + type);
			f.createNewFile();
			ImageIO.write(img, type, f);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Show up the graph on the screen. The graph is invisible by default
	 */
	public void show(){
		graph.show();
	}
}
