package histogram.trend;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import histogram.Config;
import histogram.trend.ui.TrendWindow;

/**
 * TrendGraph shows how the data changed in an time interval,
 * it is similar with histogram but it shows lines instead of bars
 * @author Daniel Xu
 *
 */
public class TrendGraph {

	/**Window with main panel**/
	private TrendWindow trend;
	
	/**
	 * Construct the TrendGraph with the default configuration
	 */
	public TrendGraph() {
		this(new Config());
	}
	
	/**
	 * Construct the TrendGraph with custom configuration, it
	 * shares the same <code>Config</code> with {@link histogram.Histogram}
	 * @param config Configuration {@link histogram.Config}
	 */
	public TrendGraph(Config config) {
		trend = new TrendWindow(config);
	}
	
	/**
	 * Add one or more trends to the TrendGraph
	 * @param trends {@link histogram.trend.Trend}
	 */
	public void add_trend(Trend...trends) {
		trend.add_trend(trends);
	}
	
	/**
	 * Show up the TrendGraph on screen, it is invisible by default
	 */
	public void show() {
		trend.show();
	}
	
	/**
	 * Save the histogram as the given image type.
	 * This method only work after the show() method is called.
	 * @param name The name of the image file
	 * @param dir The directory that the image will be saved at
	 * @param type The image type, img, jpg or png
	 */
	public void save_img(String name, String dir, String type) {
		BufferedImage img = trend.get_img();
		try{
			File f = new File(dir + "\\" + name + "." + type);
			f.createNewFile();
			ImageIO.write(img, type, f);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
