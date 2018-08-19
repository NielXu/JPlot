package histogram.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import histogram.Config;
import histogram.Section;
import histogram.ui.components.HistogramComponent;
import histogram.ui.components.LayoutComponent;
import histogram.ui.components.SectionComponent;

public class HistogramPanel extends JPanel{

	/**Configuration**/
	private Config config;
	
	/**Components**/
	private List<HistogramComponent> components;
	
	public HistogramPanel(Config config, Section[] sections) {
		super();
		setPreferredSize(new Dimension(config.width, config.height));
		this.config = config;
		components = new ArrayList<HistogramComponent>();
		components.add(new LayoutComponent(config));
		components.add(new SectionComponent(config).addSection(sections));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// Render background
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.width, config.height);
		// Render components
		for(HistogramComponent c : components) {
			c.render(g);
		}
	}
}
