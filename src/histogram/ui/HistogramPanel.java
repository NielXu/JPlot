package histogram.ui;

import java.util.List;

import common.RenderPanel;
import histogram.Config;
import histogram.Section;
import histogram.ui.components.LayoutComponent;
import histogram.ui.components.SectionComponent;

public class HistogramPanel extends RenderPanel{
	
	public HistogramPanel(Config config, List<Section> sections) {
		super(config);
		super.addRenderable(new LayoutComponent(config));
		super.addRenderable(new SectionComponent(config).addSection(sections));
	}
}
