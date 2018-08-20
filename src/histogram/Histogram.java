package histogram;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import histogram.ui.HistogramWindow;

/**
 * A histogram is an accurate representation of the distribution of numerical data.
 * User can customize the histogram and create their own graph.
 * @author Daniel Xu
 *
 */
public class Histogram {
	
	/**histogram window**/
	private HistogramWindow histogram;
	
	/**
	 * Construct a new histogram with default configuration
	 */
	public Histogram() {
		this(new Config());
	}
	
	/**
	 * Construct a new histogram with custom configuration
	 * @param config Configuration
	 */
	public Histogram(Config config) {
		histogram = new HistogramWindow(config);
	}
	
	/**
	 * Add one section on the graph. Please notice that
	 * the number os sections cannot be greater than the
	 * number of x units
	 * @param s A section {@link histogram.Section}
	 */
	public void addSection(Section s) {
		histogram.addSection(s);
	}
	
	/**
	 * Save the histogram as the given image type.
	 * This method only work after the show() method is called.
	 * @param name The name of the image file
	 * @param dir The directory that the image will be saved at
	 * @param type The image type, img, jpg or png
	 */
	public void save_img(String name, String dir, String type) {
		BufferedImage img = histogram.get_img();
		try{
			File f = new File(dir + "\\" + name + "." + type);
			f.createNewFile();
			ImageIO.write(img, type, f);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Show up the histogram, by default, it is invisible
	 */
	public void show() {
		histogram.show();
	}
}
