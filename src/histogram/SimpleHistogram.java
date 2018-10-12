package histogram;

/**
 * Simple Histogram is a sub class of Histogram. It reduces lines of codes
 * required to construct a histogram. It do the same job with Histogram. See
 * {@link histogram.Histogram}
 * 
 * @author Daniel Xu
 *
 */
public class SimpleHistogram extends Histogram {

    /** Sections and bars **/
    private int sections, bars_within;

    /** All bars on histogram **/
    private Bar[][] bars;

    /**
     * Setup the histogram by given number of sections and how many bars between one
     * section.
     * 
     * @param config   Configuration
     * @param sections Number of sections on the graph
     * @param bars     Number of bars between each section
     */
    public SimpleHistogram(Config config, int sections, int bars_within) {
	super(config);
	this.sections = sections;
	this.bars_within = bars_within;
    }

    /**
     * Setup the histogram by given number of sections and how many bars between one
     * section.
     * 
     * @param sections Number of sections on the graph
     * @param bars     Number of bars between each section
     */
    public SimpleHistogram(int sections, int bars_within) {
	this(new Config(), sections, bars_within);
    }

    /**
     * Return a two dimensional array that contains Bar for setup. The x of the
     * array is section# and the y of the array is bar#. Modifying this array will
     * directly affect the array in SimpleHistogram, therefore, only need to edit
     * this array
     * 
     * @return A two dimensional array that contains Bar for setup
     */
    public Bar[][] setup() {
	bars = new Bar[sections][bars_within];
	return bars;
    }

    @Override
    public void show() {
	Section[] s = new Section[sections];
	for (int i = 0; i < sections; i++) {
	    s[i] = new Section();
	    for (int j = 0; j < bars[i].length; j++) {
		s[i].addBar(bars[i][j]);
	    }
	    super.addSection(s[i]);
	}
	super.show();
    }
}
