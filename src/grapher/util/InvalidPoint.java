package grapher.util;

/**
 * Invalid point is the point that unabled to be calculated. For instance,
 * for the function sin(x)/x, when x=0, the function does not exist.
 * Therefore when x=0, the point is a valid point, which has Double.NaN as the y value.
 * Please notice that the y value of InvalidPoint will always be Double.NaN
 * @author Daniel Xu
 *
 */
public class InvalidPoint extends Point{

	/**
	 * Construct an invalid point, with given x value
	 * @param x X value
	 */
	public InvalidPoint(double x) {
		super(x, Double.NaN);
	}
	
}
