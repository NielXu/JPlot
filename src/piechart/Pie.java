package piechart;

import piechart.ui.PieWindow;

/**
 * Pie is a tool to
 * @author Daniel Xu
 *
 */
public class Pie {
	
	/**The window that contains the graph**/
	private PieWindow pie;
	
	/**
	 * Construct a PieChart with the default configuration
	 */
	public Pie() {
		this(new Config());
	}
	
	/**
	 * Construct a PieChart with a custom configuration
	 * @param config Configuration that applies on the PieChart
	 */
	public Pie(Config config) {
		pie = new PieWindow(config);
	}
	
	/**
	 * Add sectors to the pie chart
	 * @param sectors Sectors on the pie chart
	 */
	public void addSector(Sector... sectors) {
		pie.addSector(sectors);
	}
	
	/**
	 * Show up the pie chart on the screen
	 */
	public void show() {
		pie.show();
	}
}
