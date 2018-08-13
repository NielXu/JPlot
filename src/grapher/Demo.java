package grapher;

import java.awt.Color;

import grapher.expression.Expression;
import grapher.util.Point;
import grapher.util.Randomizer;

public class Demo {

	public static void main(String[] args){
		Grapher g = new Grapher();
		// Add two functions on graph
		g.add_exp(new Expression("x^(1/2)"));
		g.add_exp(new Expression("x+2"));
		// Must call show() to show up the graph
		g.show();
		
		// Setup your own configuration
		Config c = new Config();
		// Adjust colors, units and so on
		c.func_color = Color.YELLOW;
		c.show_grid = false;
		c.max_unit = 100;
		c.min_unit = -100;
		c.show_unit = false;
		c.size = 400;
		c.graph_location_x = 0;
		c.graph_location_y = 0;
		// Apply configuration to the grapher
		Grapher custom_grapher = new Grapher(c);
		custom_grapher.add_exp(new Expression("(x/2)*sin(x)"));
		// Show up on screen
		custom_grapher.show();
		
		// Example of drawing points
		// Randomizer providing 20 random points
		Point[] p = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Config config = new Config();
		config.size = 300;
		config.graph_location_x = 1300;
		config.graph_location_y = 0;
		Grapher pg = new Grapher(config);
		pg.add_pts(p);
		pg.show();
		
		// Linking points together
		Point[] ps = new Point[20];
		for(int i=0;i<ps.length;i++) {
			Point pt = new Point();
			pt.x  = i-10;
			pt.y = Randomizer.double_rand(-10, 10);
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
	}
	
}
