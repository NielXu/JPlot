package util.matrix;

/**
 * DimensionException is the exception that will be thrown when
 * the calculations between two matrices fail because of their
 * unmatched dimensions. We say matrix A is a*b1 and matrix
 * B is b2*c can multiply each other iff b1 = b2. The result
 * matrix will be a*c
 * @author Daniel Xu
 *
 */
public class DimensionException extends RuntimeException{

	public DimensionException(String err_msg) {
		super(err_msg);
	}
	
}
