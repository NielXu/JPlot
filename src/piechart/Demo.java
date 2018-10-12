package piechart;

import java.awt.Color;

public class Demo {

    public static void main(String[] args) {
	// PieChart is relatively simple for setup
	Pie p = new Pie();
	p.addSector(new Sector("Apple", 0.35, Color.RED), new Sector("Banana", 0.45, Color.YELLOW),
		new Sector("ORANGE", 0.2, Color.ORANGE));
	p.show();

	// Customize
	Config c = new Config();
	c.graph_location_x = 0;
	c.graph_location_y = 0;
	c.title = "Insert title here";
	Pie p2 = new Pie(c);
	// Add sectors
	p2.addSector(new Sector("sector 1", 0.1, Color.CYAN), // 0.1
		new Sector("sector 2", 0.2, Color.GREEN), // 0.1+0.2 = 0.3
		new Sector("sector 3", 0.15, Color.BLUE), // 0.3+0.15 = 0.45
		new Sector("sector 4", 0.15, Color.RED), // 0.45+0.15 = 0.6
		new Sector("sector 5", 0.025, Color.YELLOW), // 0.6+0.025 = 0.625
		new Sector("sector 6", 0.075, Color.ORANGE), // 0.625+0.075 = 0.7
		new Sector("sector 7", 0.18, Color.GRAY), // 0.7+0.18 = 0.88
		new Sector("sector 8", 0.12, Color.DARK_GRAY) // 0.88+0.12 = 1
	);
	p2.show();
    }

}
