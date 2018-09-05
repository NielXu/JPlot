package histogram;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 * The configuration of the histogram. Similar to Grapher.Config, this
 * config class also many variables that can be customized, and
 * each histogram will contain one config, they will not affect each other.
 * Please notice that this Config is different from {@link grapher.Config}
 * @author Daniel Xu
 *
 */
public class Config {
	
	/**The string array that represents the x unit on the x axis
	 * the length of the array should be equal to x_max - x_min**/
	public String[] xunit = new String[] {"2001", "2002", "2003", "2004", "2005"};
	
	/**The string array that represents the y unit on the y axis,
	 * the length of the array should be equal to y_max - y_min.
	 * <b>The difference between each two numbers should be the same</b>**/
	public double[] yunit = new double[] {10, 20, 30, 40, 50};
	
	/**The x-axis of the graph window, default is -1, which means the center of the screen, can be modified**/
	public int graph_location_x = -1;
	
	/**The y-axis of the graph window, default is -1, which means the center of the screen, can be modified**/
	public int graph_location_y = -1;

	/**The width of the graph**/
	public int width = 900;
	
	/**The height of the graph**/
	public int height = 600;
	
	/**The thickness of the trend line**/
	public int trend_thickness = 5;
	
	/**The title of the window, cannot be modified**/
	public final String TITLE = "JPlot v0.1";
	
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
	
	/**The color of the bar**/
	public Color bar_color = Color.BLUE;
	
	/**The color of the xunit**/
	public Color xunit_color = Color.BLACK;
	
	/**The color of the yunit**/
	public Color yunit_color = Color.BLACK;
	
	/**The color of the bar number**/
	public Color barnumber_color = Color.BLACK;
	
	/**The color of the category label, this also controls label on TrendGraph**/
	public Color categorylabel_color = Color.BLACK;
	
	/**The font that used by histogram title, cannot be modified for now**/
	public final Font title_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**The font that used by histogram xlabel, cannot be modified for now**/
	public final Font xlabel_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**The font that used by histogram ylabel, cannot be modified for now**/
	public final Font ylabel_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**The font that used by histogram xunit label, cannot be modified for now**/
	public final Font xunit_font = new Font("Helvetica", Font.BOLD, 12);
	
	/**The font that used by histogram yunit label, cannot be modified for now**/
	public final Font yunit_font = new Font("Helvetica", Font.BOLD, 12);
	
	/**The font that used by bar number, cannot be modified for now**/
	public final Font barnumber_font = new Font("Helvetica", Font.BOLD, 12);
	
	/**The font that used by category label, cannot be modified for now, this also controls label on TrendGraph**/
	public final Font category_font = new Font("Helvetica", Font.BOLD, 12);
	
	/**Show vertical grid on xaxis**/
	public boolean show_xgrid = true;
	
	/**Show horizontal grid on yaxis**/
	public boolean show_ygrid = true;
	
	/**Show the labels on axis**/
	public boolean show_units_label = true;
	
	/**Show the border of the vertical bar on histogram**/
	public boolean show_border = true;
	
	/**Show number on top of each bar**/
	public boolean show_bar_number = true;
	
	/**Show category on the top right corner**/
	public boolean show_category = true;
	
	/**Show a dot of trend on each x unit**/
	public boolean show_trenddot = true;
	
	/**Show trend value on top of the line**/
	public boolean show_trendnumber = true;
	
	/**Decimal Format of numbers on bar**/
	public DecimalFormat barnumber_decimal = new DecimalFormat("#0.00");
	
}
