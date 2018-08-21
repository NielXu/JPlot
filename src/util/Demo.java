package util;

import grapher.Config;
import grapher.Config.RegressionModel;
import grapher.Grapher;
import grapher.util.Point;
import util.matrix.Matrix;
import util.regression.LinearRegression;
import util.regression.Regression;

public class Demo {

	public static void main(String[] args) {
		// Random points
		Point[] p = new Point[] {
				new Point(-8.72, -10), new Point(-6.66, -7.26), new Point(-4.78, -5.54), new Point(-1.09, -5.6),
				new Point(8, 8.9), new Point(7.2, 9), new Point(3.8, 3.92), new Point(1.79, 1), new Point(0, 9)
		};
		// Customize, enable regression mode and select linear model
		Config con = new Config();
		con.show_regression = true;
		con.regression_model = RegressionModel.LINEAR;
		Grapher g = new Grapher(con);
		// Regression function only show when there are points on the graph
		g.add_pts(p);
		g.show();
		
		
		// Example of regression model
		Regression linear_model = new LinearRegression();
		double[][] m1 = new double[10][1];
		double[][] m2 = new double[1][10];
		for(int i=0;i<m1.length;i++) {
			m1[i] = Randomizer.double_randarray(-9, 9, 1);
		}
		m2[0] = Randomizer.double_randarray(-9, 9, 10);
		Matrix X = new Matrix(m1);
		Matrix y = new Matrix(m2);
		linear_model.train(X, y);
		// Can only get expression after training
		Expression e = linear_model.getExpression();
		// Visualize the result
		Point[] p2 = new Point[10];
		for(int i=0;i<p2.length;i++) {
			p2[i] = new Point(m1[i][0], m2[0][i]);
		}
		Config c = new Config();
		c.graph_location_x = 0;
		c.graph_location_y = 0;
		Grapher g2 = new Grapher(c);
		g2.add_pts(p2);
		g2.add_exp(e);
		g2.show();
		
		// More models will be added ...
	}
	
}
