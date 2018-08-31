package grapher;

import java.awt.Color;

import grapher.util.Expression;
import grapher.util.InvalidPoint;
import grapher.util.Point;
import util.Randomizer;

/**
 * Demo class for {@link grapher.Grapher}, remove '//' to
 * see the result of the codes. Each method demonstrates a
 * different example with detailed explanation.
 * @author Daniel Xu
 *
 */
public class Demo {

	public static void main(String[] args){
		/*
		 * Example of createing a simple Grapher with default Config
		 */
		// simpleGrapher().show();
		
		/*
		 * Example of creating custom Grapher
		 */
		// customGrapher().show();
		
		/*
		 * Example of drawing points on Grapher 
		 */
		// pointsGrapher().show();
		
		/*
		 * Example of drawing points and functions on a same graph
		 */
		// funcsPointsGrapher().show();
		
		/*
		 * Just an example 
		 */
		// beautifulGrapher().show();
	}
	
	/**
	 * This is an example of creating a simple Grapher with default Config,
	 * see {@link grapher.Config} for default values
	 */
	public static Grapher simpleGrapher() {
		Grapher g = new Grapher();
		Expression e1 = new Expression("x^(1/2)",	// Create Expression with given color
				Color.YELLOW);
		Expression e2 = new Expression("x^2");		// Create Expression with default color
		g.add_exp(e1, e2);							// Add multiple expressions in one line
		return g;
	}
	
	/**
	 * This is an example of creating a simple Grapher with custom Config,
	 * see {@link grapher.Config} to check out what values can be customized
	 */
	public static Grapher customGrapher() {
		Config con = new Config();		// Create custom Config, all values are public for direct access
		con.show_grid = false;			// set show_grid=false to disable grid on graph
		con.show_unit = false;			// set show_unit=false to disable unit on graph
		con.graph_location_x = 0;		// set window location x to 0
		con.graph_location_y = 0;		// set window location y to 0
		Grapher g = new Grapher(con);	// Apply Config by passing it to the Grapher constructor
		Expression e1 = new Expression("sin(x)", Color.RED);
		Expression e2 = new Expression("sin(x+90)", Color.GREEN);
		Expression e3 = new Expression("sin(x-90)", Color.BLUE);
		g.add_exp(e1, e2, e3);
		return g;
	}
	
	/**
	 * This is an example of drawing points with color on Grapher. Here we
	 * use {@link util.Randomizer} for random points, click the link for more details.
	 * The point that we use is {@link grapher.util.Point}, also check out
	 * {@link grapher.util.InvalidPoint}
	 */
	public static Grapher pointsGrapher() {
		Config con = new Config();
		con.show_unit = false;
		con.show_grid = false;
		Grapher g = new Grapher(con);
		Point[] p1 = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Point[] p2 = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Point[] p3 = Randomizer.point_randarray(-10, 10, -10, 10, 20);
		Point ip = new InvalidPoint(3);	// Creating an invalid point
		g.add_pts(Color.RED, p1);		// Add points with given color
		g.add_pts(Color.GREEN, p2);		
		g.add_pts(Color.BLUE, p3);
		g.add_pts(ip);					// Invalid point will not be drawn
		return g;
	}
	
	/**
	 * This is an example of drawing points and functions on a same graph.
	 */
	public static Grapher funcsPointsGrapher() {
		Grapher g = new Grapher();
		Expression e = new Expression("x^2");
		Point[] p = new Point[] {	// Manually adding points on function 'x^2'
			new Point(0, 0),
			new Point(1, 1),
			new Point(-1, 1),
			new Point(2, 4),
			new Point(-2, 4),
			new Point(3, 9),
			new Point(-3, 9)
		};
		g.add_exp(e);
		g.add_pts(p);
		return g;
	}
	
	/**
	 * Just an example of beautiful graph
	 */
	public static Grapher beautifulGrapher() {
		Config con = new Config();
		con.show_unit = false;
		con.show_grid = false;
		con.min_unit = -1;
		con.max_unit = 4;
		Grapher g = new Grapher(con);
		Expression e = new Expression("(x-1)^2", Color.ORANGE);
		int density = 2;
		double range = 0.5;
		Point[] evaluatedPoints = e.getPoints(-1, 3, con.density);
		for(int i=0;i<evaluatedPoints.length;i++) {
			double x = evaluatedPoints[i].x;
			double y = evaluatedPoints[i].y;
			Point[] around_r = Randomizer.point_randarray(x, x, y-range, y+range, density);
			Point[] around_g = Randomizer.point_randarray(x, x, y-range, y+range, density);
			Point[] around_b = Randomizer.point_randarray(x, x, y-range, y+range, density);
			g.add_pts(Color.RED, around_r);
			g.add_pts(Color.GREEN, around_g);
			g.add_pts(Color.BLUE, around_b);
		}
		g.add_exp(e);
		return g;
	}
}
