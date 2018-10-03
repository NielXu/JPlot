package common;

/**
 * Converttable is an interface that allows reading formatted files
 * and produce a corresponding graph of it, and also write a file that
 * with the same format.
 * @author danielxu
 *
 */
public interface Convertible {

	/**
	 * Read the formatted file with .txt extension
	 * @param file File location
	 */
	public void read(String file);
	
	/**
	 * Output the formmated file and save it to the location
	 * @param location The location that the file will be saved
	 */
	public void out(String location);
	
}
