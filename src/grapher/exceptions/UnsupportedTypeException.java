package grapher.exceptions;

/**
 * This exception will be throwed when the type of images is not supported
 * 
 * @author Daniel Xu
 *
 */
public class UnsupportedTypeException extends RuntimeException {

    public UnsupportedTypeException(String errmsg) {
	super(errmsg);
    }

}
