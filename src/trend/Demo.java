package trend;

import java.awt.Color;

import util.Randomizer;

public class Demo {
	
	public static void main(String[] args) {
		/*
		 * An example of showing trend graph
		 */
		//basictrend().show();
		
		/*
		 * An example of showing custom trend graph
		 */
		//customtrend().show();
	}
	
	/**
	 * This is an example of setting up a basic trend graph.
	 * {@link util.Randomizer} is used here to generate random values
	 */
	public static TrendGraph basictrend() {
		TrendGraph g = new TrendGraph();						// Create TrendGraph with default configuration
		double[] data1 = new double[5];							// Data represents the number of yunit that an
		double[] data2 = new double[5];							// item occupies through x axis
		double[] data3 = new double[5];
		for(int i=0;i<5;i++) {
			data1[i] = Randomizer.double_rand(0, 2);
			data2[i] = Randomizer.double_rand(2.5, 3.6);
			data3[i] = Randomizer.double_rand(3.8, 5);
		}
		Trend t1 = new Trend("APPLE", Color.RED, data1);		// Setting up trend with name 'APPLE', color RED and data1
		Trend t2 = new Trend("ORANGE", Color.ORANGE, data2);	// Setting up trend with name 'ORANGE', color ORANGE and data2
		Trend t3 = new Trend("BANANA", Color.YELLOW, data3);	// Setting up trend with name 'BANANA', color BANANA and data3
		g.add_trend(t1, t2, t3);								// Add trends to the TrendGraph
		return g;
	}
	
	/**
	 * This is an example of setting up a custom trend graph.
	 * {@link util.Randomizer} is used here to generate random values
	 */
	public static TrendGraph customtrend() {
		Config c = new Config();								// Create custom configuration, TrendGraph shares the
																// same Config class with Histogram
		c.yunit = new double[] {1000, 2000, 3000, 4000, 5000};	// Setup y unit, must be number
		c.title = "Year vs Sell";								// Change title
		c.xlabel = "Year";										// Change label on x axis
		c.ylabel = "Sell";										// Chaneg label on y axis
		c.show_xgrid = false;									// Not showing x grid
		c.show_ygrid = false;									// Not showing y grid
		TrendGraph g = new TrendGraph(c);						// Setup custom TrendGraph by passing the Config object
		double[] data1 = new double[5];							// Data represents the number of yunit that an
		double[] data2 = new double[5];							// item occupies through x axis
		double[] data3 = new double[5];
		for(int i=0;i<5;i++) {
			data1[i] = Randomizer.double_rand(0, 2);
			data2[i] = Randomizer.double_rand(2.5, 3.6);
			data3[i] = Randomizer.double_rand(3.8, 5);
		}
		Trend t1 = new Trend("APPLE", Color.RED, data1);		// Setting up trend with name 'APPLE', color RED and data1
		Trend t2 = new Trend("ORANGE", Color.ORANGE, data2);	// Setting up trend with name 'ORANGE', color ORANGE and data2
		Trend t3 = new Trend("BANANA", Color.YELLOW, data3);	// Setting up trend with name 'BANANA', color BANANA and data3
		g.add_trend(t1, t2, t3);								// Add trends to the TrendGraph
		return g;
	}

}
