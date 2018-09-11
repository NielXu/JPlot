package common;

/**
 * Every exportable graph tool should implement this interface, indicates that this
 * tool has the ability to save the graph to the designated location with given
 * image type.
 * @author Daniel Xu
 *
 */
public interface Exportable {

	/**
	 * Export the graph as an image and save to the designated location with
	 * given file name and file type.
	 * @param name The name of the file that will be saved
	 * @param dir The directory that the file will be located at. This
	 * 		must be a folder but not a specific file.
	 * @param type The image type, usually png or jpg
	 */
	public void save_img(String name, String dir, String type);
	
}
