package histogram;

/**
 * The configuration of the histogram. Similar to Grapher.Config, this
 * config class also many variables that can be customized, and
 * each histogram will contain one config, they will not affect each other
 * @author Daniel Xu
 *
 */
public class Config {
	
	/**The x-axis of the graph window, default is -1, which means the center of the screen, can be modified**/
	public int graph_location_x = -1;
	
	/**The y-axis of the graph window, default is -1, which means the center of the screen, can be modified**/
	public int graph_location_y = -1;

	/**The size of the graph**/
	public static int size = 600;
	
	/**The min unit on x axis of the histogram**/
	public static int x_min = 0;
	
	/**The max unit on x axis of the histogram**/
	public static int x_max = 5;
	
	/**The step of the x axis, step means how many unit between x_max and x_min,
	 * for instance. x_max = 5, x_min = 0, x_step = 1 will create a histogram
	 * with x axis: 0, 1, 2, 3, 4, 5**/
	public static int x_step = 5;
	
	/**The min unit on y axis of the histogram**/
	public static int y_min = 0;
	
	/**The max unit on y axis of the histogram**/
	public static int y_max = 5;

	/**The step of the y axis, step means how many unit between y_max and y_min,
	 * for instance. y_max = 5, y_min = 0, y_step = 1 will create a histogram
	 * with y axis: 0, 1, 2, 3, 4, 5**/
	public static int y_step = 5;
	
	/**The x axis label**/
	public static String xlabel = "x";
	
	/**The y axis label**/
	public static String ylabel = "y";
	
	/**The title of the graph**/
	public static String title = "Histogram";
	
}
