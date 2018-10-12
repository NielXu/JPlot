package util;

/**
 * ExceptionHandler can handle some of the common exceptions in the program.
 * 
 * @author Daniel Xu
 *
 */
public class ExceptionHandler {

    /** NULL_ARRAY means that the array that is being checked is null itself **/
    public static final int NULL_ARRAY = -1;

    /**
     * VALID_ARRAY means that the array is not null and it does not contain null
     * element
     **/
    public static final int VALID_ARRAY = -2;

    // No instance needed
    private ExceptionHandler() {
    }

    /**
     * Check if an object is null, return true if it is
     * 
     * @param obj The object that will be checked
     * @return True if the object is null, false otherwise
     */
    public static boolean isnull(Object obj) {
	return obj == null;
    }

    /**
     * Check if the array is null first, then check if there is any null elements in
     * a array
     * 
     * @param arr The array that will be checked
     * @return {@link #VALID_ARRAY}, {@link #NULL_ARRAY} or the index of the first
     *         null element in the array
     */
    public static int isnull(Object[] arr) {
	if (arr == null) {
	    return ExceptionHandler.NULL_ARRAY;
	}
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == null) {
		return i;
	    }
	}
	return ExceptionHandler.VALID_ARRAY;
    }

    /**
     * Check if the given value is out of range, if val == min or val == max, it is
     * not considered to be out of range. If the given min is greater than max, they
     * will be swapped to make sure to get a valid range
     * 
     * @param val The value that will be checked
     * @param min The min value of range
     * @param max The max value of range
     * @return True if the value is out of range, false otherwise
     */
    public static boolean outrange(int val, int min, int max) {
	// Swap min, max if min > max
	if (min > max) {
	    min = min ^ max;
	    max = min ^ max;
	    min = min ^ max;
	}
	return val < min || val > max;
    }

    /**
     * Using <code>.equals(Object) </code> to compare if the given object is equal
     * to at least one element in the given array. This method does not handle the
     * case that the object or array is null.
     * 
     * @param obj The object that will be checked
     * @param arr The array that will be compared with
     * @return True if the object equal to least one element in the array, false
     *         otherwise
     */
    public static boolean isequal(Object obj, Object[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    if (obj.equals(arr[i])) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Using <code>==</code> to compare if the given object is equal to at least one
     * element(instance) in the given array. This method does not handle the case
     * that the object or array is null.
     * 
     * @param obj The object that will be checked
     * @param arr The array that will be compared with
     * @return True if the object equal to least one element(instance) in the array,
     *         false otherwise
     */
    public static boolean isinstanceequal(Object obj, Object[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    if (obj == arr[i]) {
		return true;
	    }
	}
	return false;
    }
}
