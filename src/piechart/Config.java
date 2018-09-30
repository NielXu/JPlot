package piechart;

import java.awt.Color;
import java.awt.Font;

import common.BaseConfig;

/**
 * Configuration that applies on <b>PieChart</b>. There are
 * lots of variables for user to customize the graph.
 * @author Daniel Xu
 *
 */
public class Config extends BaseConfig{
	/**The label that displays on top of the PieChart represents the title**/
	public String title = "PieChart";
	
	/**Show sector name and percentage under the main chart**/
	public boolean show_label = true;
	
	/**The background color of the graph**/
	public Color background_color = Color.WHITE;
	
	/**The color of the title**/
	public Color title_color = Color.BLACK;
	
	/**The color of the sector label**/
	public Color sectorlabel_color = Color.BLACK;
	
	/**The font of the title, cannot be modified for now**/
	public final Font title_font = new Font("Helvetica", Font.BOLD, 18);
	
	/**The font of the label, cannot be modified for now**/
	public final Font label_font = new Font("Helvetica", Font.BOLD, 12);
	
	/**The font of the sector label, cannot be modified for now**/
	public final Font sectorlabel_font = new Font("Helvetica", Font.BOLD, 12);
}
