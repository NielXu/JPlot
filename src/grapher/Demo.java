package grapher;

import java.awt.Color;

import grapher.util.Expression;
import grapher.util.Point;
import util.Randomizer;

public class Demo {

	public static void main(String[] args){
		Grapher g = new Grapher();
		// Add two functions on graph
		g.add_exp(new Expression("x^(1/2)", Color.YELLOW));
		g.add_exp(new Expression("x+2", Color.RED));
		// Must call show() to show up the graph
		g.show();
		
		// Setup your own configuration
		Config c = new Config();
		// Adjust colors, units and so on
		c.show_grid = false;
		c.max_unit = 100;
		c.min_unit = -100;
		c.show_unit = false;
		c.size = 400;
		c.graph_location_x = 0;
		c.graph_location_y = 0;
		c.func_color = Color.YELLOW;
		// Apply configuration to the grapher
		Grapher custom_grapher = new Grapher(c);
		custom_grapher.add_exp(new Expression("(x/2)*sin(x)"));
		// Show up on screen
		custom_grapher.show();
		
		// Example of drawing points
		// Randomizer providing some random points
		Point[] p = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Point[] p2 = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Point[] p3 = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Config config = new Config();
		config.size = 500;
		config.graph_location_x = 1300;
		config.graph_location_y = 0;
		Grapher pg = new Grapher(config);
		pg.add_pts(Color.GREEN, p);
		pg.add_pts(Color.RED, p2);
		pg.add_pts(Color.ORANGE, p3);
		pg.show();
		
		// Linking points together
		Point[] ps = new Point[20];
		double[] vals = Randomizer.relative_rand(0, 2, 20);
		for(int i=0;i<ps.length;i++) {
			Point pt = new Point();
			pt.x  = i-10;
			pt.y = vals[i];
			ps[i] = pt;
		}
		Config c2 = new Config();
		c2.show_cursorxy = true;
		c2.point_color = Color.CYAN;
		c2.link_points = true;
		c2.size = 400;
		c2.graph_location_x = 0;
		c2.graph_location_y = 600;
		Grapher g2 = new Grapher(c2);
		g2.add_pts(ps);
		g2.show();
		
		// Points and Function on the same graph
		Point[] points = Randomizer.point_randarray(-10, 10, -10, 10, 30);
		Config c3 = new Config();
		c3.graph_location_x = 800;
		c3.graph_location_y = 300;
		Grapher g3 = new Grapher(c3);
		g3.add_exp(new Expression("sin(x)"));
		g3.add_pts(points);
		g3.show();
	}
	
}
