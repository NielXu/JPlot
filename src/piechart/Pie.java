package piechart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import common.AbstractGraphTool;
import piechart.ui.PiePanel;

/**
 * Pie is a tool to
 * @author Daniel Xu
 *
 */
public class Pie extends AbstractGraphTool{
	
	private List<Sector> sectors;
	
	private Config config;
	
	private JPanel panel;
	
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
		super(config);
		this.config = config;
		sectors = new ArrayList<Sector>();
	}
	
	/**
	 * Add sectors to the pie chart
	 * @param sectors Sectors on the pie chart
	 */
	public void addSector(Sector... sectors) {
		this.sectors.addAll(Arrays.asList(sectors));
	}

	@Override
	protected JPanel getGraphPanel() {
		if(panel == null) {
			panel = new PiePanel(config, sectors);
		}
		return panel;
	}
}
