package common;

/**
 * Converttable is an interface that allows reading formatted files and produce
 * a corresponding graph of it, and also write a file that with the same format.
 * 
 * @author danielxu
 *
 */
public interface Convertible {

    /**
     * Read the formatted file with .txt extension
     * 
     * @param file File location
     */
    public void read(String file);

    /**
     * Output the formatted file and save it to the given file. If the file does not
     * exist, a new file will be created
     * 
     * @param A file that will be written, or create the new file with given path
     *          and name
     */
    public void out(String location);

}
