package grapher.exceptions;

/**
 * This exception will be raised when the show() method is not
 * called but the save_img() is called
 * @author Daniel Xu
 *
 */
public class ImageSavedException extends RuntimeException{

	public ImageSavedException(String errmsg) {
		super(errmsg);
	}
	
}
