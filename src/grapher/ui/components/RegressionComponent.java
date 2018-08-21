package grapher.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import grapher.Config;
import grapher.Config.RegressionModel;
import grapher.util.Buffer;
import grapher.util.Point;
import util.Expression;
import util.matrix.Matrix;
import util.regression.LinearRegression;
import util.regression.Regression;

/**
 * RegressionComponent is responsible for doing regression
 * based on the points on the graph and draw the expression. 
 * @author Daniel Xu
 *
 */
public class RegressionComponent extends GraphComponent{

	private List<Buffer> buffers;
	
	public RegressionComponent(Config config) {
		super(config);
	}
	
	@Override
	public RegressionComponent add_pts(List<Buffer> buffers) {
		this.buffers = buffers;
		return this;
	}

	@Override
	public void render(Graphics g) {
		regress(g);
	}
	
	private void regress(Graphics g) {
		if(buffers.size() == 0) {
			return;
		}
		if(config.show_regression) {
			List<Point> p = new ArrayList<Point>();
			for(int i=0;i<buffers.size();i++) {
				p.addAll(Arrays.asList(buffers.get(i).getPoints()));
			}
			double[][] m1 = new double[p.size()][1];
			double[][] m2 = new double[1][p.size()];
			for(int i=0;i<p.size();i++) {
				m1[i][0] = p.get(i).x;
				m2[0][i] = p.get(i).y;
			}
			Matrix X = new Matrix(m1);
			Matrix y = new Matrix(m2);
			Regression model = null;
			if(config.regression_model == RegressionModel.LINEAR) {
				model = new LinearRegression();
			}
			model.train(X, y);
			Expression e = model.getExpression();
			e.applyConfig(config);
			e.getPoints();
			super.render_expression(g, e);
			renderexpressions(g, e);
		}
	}
	
	private void renderexpressions(Graphics g, Expression e) {
		if(config.show_expressions) {
			Color c = e.getColor();
			String sexp = e.getExpression();
			g.setColor(c);
			g.drawString("y=" + sexp, config.size-150, config.size-25);
		}
	}

}
