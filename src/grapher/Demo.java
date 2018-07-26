package grapher;

import grapher.expression.Expression;
import grapher.util.Point;

public class Demo {

	public static void main(String[] args){
		Grapher g = new Grapher();
		// Add two functions on graph
		g.add_exp(new Expression("x^(1/2)"));
		g.add_exp(new Expression("x+2"));
		Point[] p = new Point[50];
		for(int i=0;i<p.length;i++){
			p[i] = new Point((Math.random()*21-10), (Math.random()*21-10));
		}
		g.add_pts(p);
		// Must call show()
		g.show();
		
		// Setup your own configuration
		//Config c = new Config();
		// Adjust colors, units and so on
		//c.func_color = Color.YELLOW;
		//c.show_grid = false;
		//c.max_unit = 100;
		//c.min_unit = -100;
		//c.show_unit = false;
		// Apply configuration to the grapher
		//Grapher custom_grapher = new Grapher(c);
		//custom_grapher.add(new Expression("(x/2)*sin(x)"));
		// Show up on screen
		//custom_grapher.show();
		
	}
	
}
