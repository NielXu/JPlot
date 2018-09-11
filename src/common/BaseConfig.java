package common;

import java.awt.Color;

/**
 * The base configuration that all configurations shared. It contains six
 * methods that can be overrided by children configuration classes, which
 * defines the default location of the graph, default dimension of the graph,
 * default background color of the graph and a boolean that decides should
 * high quality mode be turned on or not<br>
 * 
 * Only children configuration class can override them, however, the overrided values
 * just represent the default values, user can still modify them by changing public
 * variables directly. It is more convenience and not necessarily to call too many
 * getters and setters.
 * @author Daniel Xu
 *
 */
public class BaseConfig {
	
	/**
	 * Get the graph location x value, override this method
	 * to change the <b>default</b> graph location x value
	 * @return The x value of the graph's location
	 */
	protected int getGraphX() {return -1;}
	
	/**
	 * Get the graph location y value, override this method
	 * to change the <b>default</b> graph location y value
	 * @return The y value of the graph's location
	 */
	protected int getGraphY() {return -1;}
	
	/**
	 * Get the width of the graph, override this method to
	 * change the <b>default</b> width of the graph
	 * @return Width of the graph
	 */
	protected int getWidth() {return 600;}
	
	/**
	 * Get the height of the graph, override this method to
	 * change the <b>default</b> height of the graph
	 * @return Height of the graph
	 */
	protected int getHeight() {return 600;}
	
	/**
	 * Get the background color of the graph, override this method to
	 * change the <b>default</b> background color of the graph
	 * @return Background color of the graph
	 */
	protected Color getBackgroundColor() {return Color.WHITE;}
	
	/**
	 * Get a boolean value that represents if the high quality
	 * mode should be on or not, override this method to change
	 * the <b>default</b> option to enable high quality or not
	 * @return True if enable high quality mode, false otherwise
	 */
	protected boolean enableHighQuality() {return true;}
	
	/**TITLE of the window, cannot be modified**/
	public final String TITLE = "JPlot v0.2";
	
	/**x value of the graph location, -1 means center of the screen**/
	public int graph_location_x = getGraphX();
	
	/**y value of the graph location, -1 means center of the screen**/
	public int graph_location_y = getGraphY();
	
	/**Width of the graph**/
	public int width = getWidth();
	
	/**Height of the graph**/
	public int height = getHeight();
	
	/**Background color**/
	public Color background_color = getBackgroundColor();
	
	/**True to enable high quality, false to disable**/
	public boolean high_quality = enableHighQuality();
}
