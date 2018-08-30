package piechart.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import piechart.Config;
import piechart.Sector;
import piechart.ui.components.PieComponent;
import piechart.ui.components.SectorComponent;
import piechart.ui.components.TitleComponent;

/**
 * PiePanel is the JPanel that contains all render parts
 * @author Daniel Xu
 *
 */
public class PiePanel extends JPanel{

	/**Configuration**/
	private Config config;

	/**List of components**/
	private List<PieComponent> components;
	
	public PiePanel(Config config, List<Sector> sectors) {
		super();
		this.config = config;
		setPreferredSize(new Dimension(config.size, config.size));
		components = new ArrayList<PieComponent>();
		components.add(new TitleComponent(config));
		components.add(new SectorComponent(config).addSector(sectors));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw background
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.size, config.size);
		for(PieComponent c : components) {
			c.render(g);
		}
	}
}
