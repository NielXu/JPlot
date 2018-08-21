package util.matrix;

import java.math.BigDecimal;

/**
 * Linear is a util class that helps doing linear algebra calculatoins such as dot product. The
 * methods in this class usually take BigDecimal as arg since it is a support class to Matrix
 * @author Daniel Xu
 *
 */
public class Linear {

	// Static class, no instance required
	private Linear() {}
	
	/**
	 * Doing dot product calculation between two vectors(arrays). The result will be
	 * a BigDecimal number. Two two vectors must have a same length in order to
	 * do the calculation.
	 * @param v1 Vector 1
	 * @param v2 Vector 2
	 * @return A BigDecimal number as the result
	 */
	public static BigDecimal dot(BigDecimal[] v1, BigDecimal[] v2) {
		if(v1 == null && v2 == null)
			throw new NullPointerException("Vector cannot be null");
		if(v1.length != v2.length)
			throw new DimensionException("Vectors must have same length for dot product calculation");
		BigDecimal result = new BigDecimal("0");
		for(int i=0;i<v1.length;i++) {
			result = result.add(v1[i].multiply(v2[i]));
		}
		return result;
	}
	
}
