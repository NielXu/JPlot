package histogram;

import java.util.ArrayList;
import java.util.List;

/**
 * Section represent one unit of x axis in histogram. One unit can contain
 * multiple bars.
 * @author Daniel Xu
 *
 */
public class Section {

	private List<Bar> bars;
	
	public Section() {
		bars = new ArrayList<Bar>();
	}
	
	/**
	 * Add one or more bars to the histogram
	 * @param b Array of bar {@link histogram.Bar}
	 */
	public void addBar(Bar... bars) {
		for(Bar b : bars) {
			this.bars.add(b);
		}
	}
	
	/**
	 * Get all the bars that this section contains
	 * @return Array of bar
	 */
	public List<Bar> getBars(){
		return bars;
	}
	
}
