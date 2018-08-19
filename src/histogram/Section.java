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
	
	public void addBar(Bar b) {
		bars.add(b);
	}
	
	public void setBar(int index, Bar b) {
		bars.set(index, b);
	}
	
	public List<Bar> getBars(){
		return bars;
	}
	
}
