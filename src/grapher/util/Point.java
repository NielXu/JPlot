package grapher.util;

/**
 * Implements Point class with double x and y values.
 * 
 * @author danielxu
 *
 */
public class Point {

    /** x and y values in double **/
    public double x, y;

    /** Default constructor, x = 0.0, y = 0.0 **/
    public Point() {
	x = 0f;
	y = 0f;
    }

    /**
     * Construct the double point by providing x and y values
     * 
     * @param x x-axis of the point in double
     * @param y y-axis of the point in double
     */
    public Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    @Override
    public String toString() {
	return "[x=" + x + ", y=" + y + "]";
    }

}
