package util.regression;

import java.math.BigDecimal;
import java.math.RoundingMode;

import util.Expression;
import util.matrix.Matrix;

/**
 * Regression is a interface that all regression model should implements.
 * All models can do, train, predict and get expression. It also contains
 * static methods for regression calculation
 * @author Daniel Xu
 *
 */
public interface Regression {

	public abstract double predict(Matrix x);
	
	public abstract void train(Matrix x, Matrix y);
	
	public abstract Expression getExpression();
	
	/**
	 * Calculate the mean of the given data
	 * @param data Data, in BigDecimal array format
	 * @return A BigDecimal represents the mean of the data
	 */
	public static BigDecimal mean(BigDecimal... data) {
		BigDecimal sum = new BigDecimal("0");
		for(int i=0;i<data.length;i++) {
			sum = sum.add(data[i]);
		}
		return sum.divide(new BigDecimal(data.length), 2, RoundingMode.HALF_UP);
	}
	
	/**
	 * Calculate the variance of sample of the given data
	 * @param data Data, in BigDecimal array format
	 * @return A BigDecimal represents the variance of sample of the data
	 */
	public static BigDecimal vars(BigDecimal...data) {
		BigDecimal mean = Regression.mean(data);
		BigDecimal sum = new BigDecimal("0");
		for(int i=0;i<data.length;i++) {
			BigDecimal diff = data[i].subtract(mean);
			sum = sum.add(diff.multiply(diff));
		}
		return sum.divide(new BigDecimal(data.length-1), 2, RoundingMode.HALF_UP);
	}
	
	/**
	 * Calculate the variance of population of the given data
	 * @param data Data, in BigDecimal array format
	 * @return A BigDecimal represents the variance of population of the data
	 */
	public static BigDecimal varp(BigDecimal...data) {
		BigDecimal mean = Regression.mean(data);
		BigDecimal sum = new BigDecimal("0");
		for(int i=0;i<data.length;i++) {
			BigDecimal diff = data[i].subtract(mean);
			sum = sum.add(diff.multiply(diff));
		}
		return sum.divide(new BigDecimal(data.length), 2, RoundingMode.HALF_UP);
	}
	
	/**
	 * Calculate the covariance between two data. The order of data does not matter.
	 * @param data1 Data, in BigDecimal array format
	 * @param data2 Data, in BigDecimal array format
	 * @return A BigDecimal represents the covariance between two data
	 */
	public static BigDecimal cov(BigDecimal[] data1, BigDecimal[] data2) {
		BigDecimal mean1 = Regression.mean(data1);
		BigDecimal mean2 = Regression.mean(data2);
		BigDecimal sum = new BigDecimal("0");
		for(int i=0;i<data1.length;i++) {
			BigDecimal diff1 = data1[i].subtract(mean1);
			BigDecimal diff2 = data2[i].subtract(mean2);
			sum = sum.add(diff1.multiply(diff2));
		}
		return sum.divide(new BigDecimal(data1.length-1), 2, RoundingMode.HALF_UP);
	}
}
