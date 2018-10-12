package histogram;

import java.util.ArrayList;
import java.util.List;

/**
 * Section represent one unit of x axis in histogram. One unit can contain
 * multiple bars.
 * 
 * @author Daniel Xu
 *
 */
public class Section {

    private List<Bar> bars;

    /**
     * Construct section with no bar by default
     */
    public Section() {
	bars = new ArrayList<Bar>();
    }

    /**
     * Construct section by providing list of bars in one section
     * 
     * @param bars List of {@link histogram.Bar}
     */
    public Section(List<Bar> bars) {
	this.bars = bars;
    }

    /**
     * Add one or more bars to the histogram
     * 
     * @param b Array of bar {@link histogram.Bar}
     */
    public void addBar(Bar... bars) {
	for (Bar b : bars) {
	    this.bars.add(b);
	}
    }

    /**
     * Get all the bars that this section contains
     * 
     * @return Array of bar
     */
    public List<Bar> getBars() {
	return bars;
    }

}
