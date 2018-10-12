package histogram;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import common.AbstractGraphTool;
import common.RenderPanel;
import histogram.ui.HistogramPanel;

/**
 * A histogram is an accurate representation of the distribution of numerical
 * data. User can customize the histogram and create their own graph.
 * 
 * @author Daniel Xu
 *
 */
public class Histogram extends AbstractGraphTool {

    private List<Section> sections;

    /** The JPanel that contains all rendering stuff **/
    private RenderPanel panel;

    /** Configuration **/
    private Config config;

    /**
     * Construct a new histogram with default configuration
     */
    public Histogram() {
	this(new Config());
    }

    /**
     * Construct a new histogram with custom configuration
     * 
     * @param config Configuration
     */
    public Histogram(Config config) {
	super(config);
	sections = new ArrayList<Section>();
	this.config = config;
    }

    /**
     * Add one or more section on the graph. Please notice that the number os
     * sections cannot be greater than the number of x units
     * 
     * @param sections Array of section {@link histogram.Section}
     */
    public void addSection(Section... sections) {
	for (Section s : sections) {
	    this.sections.add(s);
	}
    }

    @Override
    protected JPanel getGraphPanel() {
	if (panel == null) {
	    panel = new HistogramPanel(config, sections);
	}
	return panel;
    }
}
