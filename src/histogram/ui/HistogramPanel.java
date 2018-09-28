package histogram.ui;

import java.awt.Dimension;
import java.util.List;

import common.RenderPanel;
import histogram.Config;
import histogram.Section;
import histogram.ui.components.LayoutComponent;
import histogram.ui.components.SectionComponent;

public class HistogramPanel extends RenderPanel{
	
	public HistogramPanel(Config config, List<Section> sections) {
		super(config);
		setPreferredSize(new Dimension(config.width, config.height));
		this.config = config;
		super.addRenderable(new LayoutComponent(config));
		super.addRenderable(new SectionComponent(config).addSection(sections));
	}
}
