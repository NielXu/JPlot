package grapher;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import grapher.exceptions.ImageSavedException;
import grapher.exceptions.SizeOutOfRangeException;
import grapher.exceptions.UnsupportedTypeException;
import grapher.ui.GraphWindow;
import grapher.util.Expression;
import grapher.util.Point;
import util.ExceptionHandler;

/**
 * The Grapher is a tool that shows function on the screen.
 * @author danielxu
 *
 */
public class Grapher {

	/**The graph window**/
	private GraphWindow graph;
	
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
		if(ExceptionHandler.isnull(config)) {
			throw new NullPointerException("Configuration cannot be null");
		}
		graph = new GraphWindow(config);
		this.config = config;
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
		graph.buffer_pts(points, c, size);
	}
	
	/**
	 * Save the graph on the grapher as the given image type.
	 * This method only work after the show() method is called.
	 * @param name The name of the image file
	 * @param dir The directory that the image will be saved at
	 * @param type The image type, support jpg, png
	 */
	public void save_img(String name, String dir, String type) {
		if(ExceptionHandler.isnull(name)) {
			throw new NullPointerException("File name cannot be null");
		}
		if(ExceptionHandler.isnull(dir)) {
			throw new NullPointerException("Directory cannot be null");
		}
		if(ExceptionHandler.isnull(type)) {
			throw new NullPointerException("File type cannot be null");
		}
		if(!ExceptionHandler.isequal(type, new Object[] {"png", "jpg"})) {
			throw new UnsupportedTypeException("Image type " + type + " not supported");
		}
		if(!graph.ready()) {
			throw new ImageSavedException("Cannot saved image before show");
		}
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
