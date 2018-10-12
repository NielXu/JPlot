package histogram;

import java.awt.Color;

import util.Randomizer;

/**
 * This is the Demo class that demonstrates how to use Histogram and TrendGraph.
 * To see the result of the codes remove '//' before the calling method
 * 
 * @author Daniel Xu
 *
 */
public class Demo {

    public static void main(String[] args) {
	/*
	 * Example of basic histogram
	 */
	// basichist().show();

	/*
	 * Example of custom histogram
	 */
	// customhist().show();

	/*
	 * Example of simple histogram
	 */
	// simplehist().show();
    }

    /**
     * This is an exmaple of setting up a basic histogram, with default
     * configuration, {@link util.Randomizer} is used here to generate random values
     */
    public static Histogram basichist() {
	Histogram h = new Histogram(); // Create histogram instance with default configuration
	Category c1 = new Category("APPLE", Color.RED); // Setting up category with name 'APPLE', color RED
	Category c2 = new Category("ORANGE", Color.ORANGE); // Setting up category with name 'ORANGE', color ORANGE
	Category c3 = new Category("BANABA", Color.YELLOW); // Setting up category with name 'BANANA', color YELLOW

	Section s1 = new Section(); // Each section represents one x unit on the histogramm, and it can have
				    // multiple bars.
				    // The number of section is determind by the length of xunit in Config
	s1.addBar(new Bar(Randomizer.double_rand(0, 5), c1)); // Each bar contain a value that represents how many yunit
							      // it occupym and a category it belongs with
	s1.addBar(new Bar(Randomizer.double_rand(0, 5), c2));
	s1.addBar(new Bar(Randomizer.double_rand(0, 5), c3));
	Section s2 = new Section(); // Repeat util all sections are setup
	s2.addBar(new Bar(Randomizer.double_rand(0, 5), c1));
	s2.addBar(new Bar(Randomizer.double_rand(0, 5), c2));
	s2.addBar(new Bar(Randomizer.double_rand(0, 5), c3));
	Section s3 = new Section();
	s3.addBar(new Bar(Randomizer.double_rand(0, 5), c1));
	s3.addBar(new Bar(Randomizer.double_rand(0, 5), c2));
	s3.addBar(new Bar(Randomizer.double_rand(0, 5), c3));
	Section s4 = new Section();
	s4.addBar(new Bar(Randomizer.double_rand(0, 5), c1));
	s4.addBar(new Bar(Randomizer.double_rand(0, 5), c2));
	s4.addBar(new Bar(Randomizer.double_rand(0, 5), c3));
	Section s5 = new Section();
	s5.addBar(new Bar(Randomizer.double_rand(0, 5), c1));
	s5.addBar(new Bar(Randomizer.double_rand(0, 5), c2));
	s5.addBar(new Bar(Randomizer.double_rand(0, 5), c3));

	h.addSection(s1, s2, s3, s4, s5); // Add sections to the histogram
	return h;
    }

    /**
     * This is an example of setting up a histogram with custom configuration
     * {@link util.Randomizer} is used here to generate random values
     */
    public static Histogram customhist() {
	Config c = new Config();
	c.xunit = new String[] { "1", "2", "3", "4", "5", // Setting up x units
		"6", "7", "8", "9", "10" };
	c.yunit = new double[] { 10, 20, 30, 40, 50, // Setting up y units, must be number
		60, 70, 80, 90, 100 };
	c.xlabel = "level"; // Setting up the x axis label of the histogram
	c.ylabel = "percentage"; // Setting up the y axis label of the histogram
	c.show_xgrid = false; // Not showing x grid on the graph
	c.title = "Level vs Percentage"; // Setting up the title of the histogram
	Histogram h = new Histogram(c);
	Category c1 = new Category("sample1", Color.GREEN); // Create category with name 'sample1', color GREEN
	Category c2 = new Category("sample2", Color.RED); // Create category with name 'sample2', color RED
	for (int i = 0; i < c.xunit.length; i++) { // Loop through the x units
	    Section s = new Section(); // For each x unit, create a section
	    s.addBar(new Bar(Randomizer.double_rand(0, 10), c1)); // Add a bar that belongs to category1 to the section
	    s.addBar(new Bar(Randomizer.double_rand(0, 10), c2)); // Add a bar that belongs to category2 to the section
	    h.addSection(s); // Add section to the histogram
	}
	return h;
    }

    /**
     * This is an example of setting up the histogram by using SimpleHistogram
     * class, which extends Histogram class. It simplifies the setup process by
     * providing a 2d array that represents sections and bars. User only need to
     * fill the array instead of adding them manually {@link util.Randomizer} is
     * used here to generate random values
     */
    public static Histogram simplehist() {
	Category[] c = new Category[] { new Category("APPLE", Color.RED), // Setting up a category array
		new Category("ORANGE", Color.ORANGE), new Category("BANABA", Color.YELLOW) };
	SimpleHistogram h = new SimpleHistogram(5, 3); // Create SimpleHistogram instance, provides
						       // # of sectoins and # of bars in each section
	Bar[][] b = h.setup(); // Get the setup array by calling setup()
	for (int i = 0; i < b.length; i++) { // Loop through the array, i=index of section
	    for (int j = 0; j < b[i].length; j++) { // j=inedx of bar
		b[i][j] = new Bar(Randomizer.double_rand(0, 5), // Setup bar
			c[j]);
	    }
	}
	return h;
    }

}
