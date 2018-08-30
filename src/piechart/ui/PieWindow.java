package piechart.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import piechart.Config;
import piechart.Sector;

public class PieWindow {
	
	/**List of sectors**/
	private List<Sector> sectors;

	/**JFrame Window**/
	private JFrame frame;
	
	/**The JPanel that contains render contentes**/
	private JPanel panel;
	
	/**Configuration**/
	private Config config;
	
	/**
	 * Construct the window and apply configuration on it
	 * @param config The Config object
	 */
	public PieWindow(Config config) {
		frame = new JFrame(config.TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		sectors = new ArrayList<Sector>();
		this.config = config;
	}
	
	/**
	 * Add a sector to the pie chart
	 * @param sectors Sectors on the graph
	 */
	public void addSector(Sector...sectors) {
		this.sectors.addAll(Arrays.asList(sectors));
	}
	
	/**
	 * Show up the window, it is invisible by default
	 */
	public void show() {
		panel = new PiePanel(config, sectors);
		frame.add(panel);
		frame.pack();
		if(config.graph_location_x == -1 && config.graph_location_y == -1) frame.setLocationRelativeTo(null);
		else frame.setLocation(config.graph_location_x, config.graph_location_y);
		frame.setVisible(true);
	}
}
