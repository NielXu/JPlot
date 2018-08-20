package histogram;

import java.awt.Color;

import grapher.util.Randomizer;

public class Demo {

	public static void main(String[] args) {
		// Histogram is a bit complex with setup
		// compare with grapher, since it require more details
		Histogram h = new Histogram();
		// Setup category: APPLE, ORANGE, BANANA
		Category c1 = new Category("APPLE", Color.RED);
		Category c2 = new Category("ORANGE", Color.ORANGE);
		Category c3 = new Category("BANABA", Color.YELLOW);
		
		// Create new section
		Section s1 = new Section();
		// Add 3 bars to section1, with random values
		s1.addBar(new Bar(Randomizer.double_rand(0, 5), c1));
		s1.addBar(new Bar(Randomizer.double_rand(0, 5), c2));
		s1.addBar(new Bar(Randomizer.double_rand(0, 5), c3));
		
		// Repeat steps until the graph is full
		Section s2 = new Section();
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
		
		// Add sections to the histogram
		h.addSection(s1);
		h.addSection(s2);
		h.addSection(s3);
		h.addSection(s4);
		h.addSection(s5);
		// Display
		h.show();
		h.save_img("histogram", "F:\\github\\Grapher\\resources", "jpg");
		
		
		// SimpleHistogram simplifies the steup proccess by providing a
		// 2d array of bars
		// The following codes will do the same with the above, however,
		// the diagram will look different since the values are random
		Config con = new Config();
		con.graph_location_x = 0;
		con.graph_location_y = 0;
		Category[] c = new Category[] {new Category("APPLE", Color.RED),
									   new Category("ORANGE", Color.ORANGE),
									   new Category("BANABA", Color.YELLOW)};
		SimpleHistogram h2 = new SimpleHistogram(con, 5, 3);
		Bar[][] b = h2.setup();
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				b[i][j] = new Bar(Randomizer.double_rand(0, 5), c[j]);
			}
		}
		h2.show();
	}
}
