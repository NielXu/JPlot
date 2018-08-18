package histogram;

import java.awt.Color;
import java.awt.Font;

/**
 * The configuration of the histogram. Similar to Grapher.Config, this
 * config class also many variables that can be customized, and
 * each histogram will contain one config, they will not affect each other.
 * Please notice that this Config is different from {@link grapher.Config}
 * @author Daniel Xu
 *
 */
public class Config {
	
	/**The x-axis of the graph window, default is -1, which means the center of the screen, can be modified**/
	public int graph_location_x = -1;
	
	/**The y-axis of the graph window, default is -1, which means the center of the screen, can be modified**/
	public int graph_location_y = -1;

	/**The width of the graph**/
	public int width = 900;
	
	/**The height of the graph**/
	public int height = 600;
	
	/**The min unit on x axis of the histogram**/
	public int x_min = 0;
	
	/**The max unit on x axis of the histogram**/
	public int x_max = 5;
	
	/**The step of the x axis, step means how many unit between x_max and x_min,
	 * for instance. x_max = 5, x_min = 0, x_step = 1 will create a histogram
	 * with x axis: 0, 1, 2, 3, 4, 5**/
	public int x_step = 5;
	
	/**The min unit on y axis of the histogram**/
	public int y_min = 0;
	
	/**The max unit on y axis of the histogram**/
	public int y_max = 5;

	/**The step of the y axis, step means how many unit between y_max and y_min,
	 * for instance. y_max = 5, y_min = 0, y_step = 1 will create a histogram
	 * with y axis: 0, 1, 2, 3, 4, 5**/
	public int y_step = 5;
	
	/**The title of the window, this is different from title and cannot be modified**/
	public final String TITLE = "Grapher v0.1";
	
	/**The x axis label**/
	public String xlabel = "x label";
	
	/**The y axis label**/
	public String ylabel = "y label";
	
	/**The title of the graph**/
	public String title = "Histogram";
	
	/**The background color of the histogram**/
	public Color background_color = Color.WHITE;
	
	/**The gird color of the histogram, only workds when show_grid is enableed**/
	public Color grid_color = Color.DARK_GRAY;
	
	/**The axis color of the histogram**/
	public Color axis_color = Color.BLACK;
	
	/**The unit color of the histogram**/
	public Color unit_color = Color.RED;
	
	/**The histogram title color**/
	public Color title_color = Color.BLACK;
	
	/**The color of the xlabel**/
	public Color xlabel_color = Color.BLACK;
	
	/**The font that used by histogram title, cannot be modified for now**/
	public final Font title_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**The font that used by histogram xlabel, cannot be modified for now**/
	public final Font xlabel_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**The font that used by histogram ylabel, cannot be modified for now**/
	public final Font ylabel_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**Show grid on the histogram**/
	public boolean show_grid = true;
}
