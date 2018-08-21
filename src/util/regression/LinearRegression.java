package util.regression;

import java.math.BigDecimal;
import java.math.RoundingMode;

import util.Expression;
import util.matrix.Matrix;

/**
 * Simple Linear Regression, try to find best fit linear function with given matrices.
 * Simple Linear Regression means it takes only one independent variable. Therefore,
 * the X matrix should only contains one column. Formula:<br>
 * <center>y=b + x0b0</center>
 * @author Daniel Xu
 *
 */
public class LinearRegression implements Regression{
	
	/**Important variables**/
	private BigDecimal k, b;

	@Override
	public Expression getExpression() {
		return new Expression("("+k.toString() + ")*x + (" + b.toString()+")");
	}

	/**
	 * Makes prediction with the trained model, the given Matrix should only
	 * contains one element since it is SimpleLinearRegression
	 */
	@Override
	public double predict(Matrix x) {
		BigDecimal e = x.get(0, 0);
		return k.multiply(e).add(b).doubleValue();
	}

	@Override
	public void train(Matrix x, Matrix y) {
		BigDecimal[] trainx = x.get_col(0);
		BigDecimal[] trainy = y.get_row(0);
		train_var(trainx, trainy);
	}
	
	// Calculate variables
	private void train_var(BigDecimal[] trainx, BigDecimal[] trainy) {
		BigDecimal cov = Regression.cov(trainx, trainy);
		BigDecimal vars = Regression.vars(trainx);
		BigDecimal xmean = Regression.mean(trainx);
		BigDecimal ymean = Regression.mean(trainy);
		k = cov.divide(vars, 2, RoundingMode.HALF_UP);
		b = ymean.subtract(k.multiply(xmean));
	}
}
