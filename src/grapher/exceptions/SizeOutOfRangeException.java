package grapher.exceptions;

/**
 * This exception will be raised when the given point size is not in a valid
 * range
 * 
 * @author Daniel Xu
 *
 */
public class SizeOutOfRangeException extends RuntimeException {

    public SizeOutOfRangeException(String errmsg) {
	super(errmsg);
    }

}
