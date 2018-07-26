package grapher.util;

/**
 * Randomizer provides some useful methods to get random values. Please ensure that the 
 * type of random, since there are int type and double type. Randomizer is static therefore
 * no instance needed
 * @author Daniel Xu
 *
 */
public class Randomizer {

	private Randomizer() {}
	
	/**
	 * Get an random <b>integer</b> in range(min, max), where min and max are included. If the
	 * max < min, the random inetegr will still in range(min, max)
	 * @param min The min value, included
	 * @param max The max value, included
	 * @return An random integer in range(min, max)
	 */
	public static int int_rand(int min, int max) {
		return (int)(Math.random()*(max-min+1))+min;
	}
	
	/**
	 * Get an array of random <b>integers</b>, the integers will be in range(min, max), where
	 * min and max are included.If the max < min, the random inetegrs will still in range(min, max)
	 * @param min The min value, included
	 * @param max The max value, included
	 * @param capacity The total capacity of the array, how many integers will be generated
	 * @return Array that contains random integers
	 */
	public static int[] int_randarray(int min, int max, int capacity) {
		int[] arr = new int[capacity];
		for(int i=0;i<capacity;i++) {
			arr[i] = int_rand(max, min);
		}
		return arr;
	}
	
	/**
	 * Get an random <b>double</b> in range(min, max), where min and max are included. If the
	 * max < min, the random nunber will still in range(min, max)
	 * @param min The min value, included
	 * @param max The max value, included
	 * @return An random number(floating points) in range(min, max)
	 */
	public static double double_rand(double min, double max) {
		return Math.random()*(max-min)+min;
	}
	
	/**
	 * Get an array of random <b>doubles</b>, the numbers will be in range(min, max), where
	 * min and max are included.If the max < min, the random numbers will still in range(min, max)
	 * @param min The min value, included
	 * @param max The max value, included
	 * @param capacity The total capacity of the array, how many numbers will be generated
	 * @return Array that contains random numbers(floating points)
	 */
	public static double[] double_randarray(double min, double max, int capacity) {
		double[] arr = new double[capacity];
		for(int i=0;i<capacity;i++) {
			arr[i] = double_rand(min, max);
		}
		return arr;
	}
	
	/**
	 * Get a random point with x in range(x_min, x_max) and y in range(y_min, y_max),
	 * where x_min, y_min, x_max, y_max are included. The x,y axises will be in double format.
	 * @param x_min The min vlaue of x, included
	 * @param x_max The max value of x, included
	 * @param y_min The min value of y, included
	 * @param y_max The max value of y, included
	 * @return A point with random x,y axises in given range
	 */
	public static Point point_rand(double x_min, double x_max, double y_min, double y_max) {
		return new Point(double_rand(x_min, x_max), double_rand(y_min, y_max));
	}
	
	/**
	 * Get an array contains <b>point</b> with random location. x in range(x_min, x_max) and y in range(y_min, y_max),
	 * where x_min, y_min, x_max, y_max are included. The x,y axises of the points will be in double format.
	 * @param x_min The min vlaue of x, included
	 * @param x_max The max value of x, included
	 * @param y_min The min value of y, included
	 * @param y_max The max value of y, included
	 * @param capacity The total capacity of the array, how many points will be generated
	 * @return Array that contains points with random locations
	 */
	public static Point[] point_randarray(double x_min, double x_max, double y_min, double y_max, int capacity) {
		Point[] p = new Point[capacity];
		for(int i=0;i<capacity;i++) {
			p[i] = point_rand(x_min, x_max, y_min, y_max);
		}
		return p;
	}
	
}
