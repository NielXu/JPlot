package common;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * AbstractGraphTool is an abstract class that contains methods that are ready
 * to use such as {@link #show()}. And there is only one method that needed to
 * be implements {@link #getGraphPanel()} which retunrs a JPanel that contains
 * the content of the graph. This method can only be overrided and called by its
 * children classes.<br>
 * AbstractGraphTool also implements the {@link common.Exportable} interface, which
 * contains method {@link #save_img(String, String, String)} that can save the graph
 * as an image.
 * @author Daniel Xu
 *
 */
public abstract class AbstractGraphTool implements Exportable{
	
	/**The JFrame that provide window for JPanel**/
	protected JFrame frame;
	
	/**Base configuration**/
	protected BaseConfig config;
	
	/**Exported image**/
	protected BufferedImage img;
	
	/**
	 * Construct the GraphTool with base configuration. This constructor
	 * will setup a window that is ready for JPanel to be added,
	 * set default close operation to <code>JFrame.DISPOSE_ON_CLOSE</code>
	 * and set the window not resizable
	 * @param config Base configuration or any configuration that overrides Base configuration
	 */
	public AbstractGraphTool(BaseConfig config) {
		this.config = config;
		frame = new JFrame(config.TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	}
	
	/**
	 * Get the JPanel that contains the graph on it. The recommend way to
	 * return the JPanel is to initialize it once in this method if it is null.
	 * The code could be like:
	 * <pre>
	 * {@code
	 * if(panel == null)
	 * 	panel = new ExplicitlyDefinedPanel(var1, var2, ...);
	 * 
	 * return panel;
	 * }
	 * </pre>
	 * Where <code>ExplicitlyDefinedPanel</code> means any class that extends JPanel, and <code>var1, var2,...</code>
	 * means the elements that users added on the graph.
	 * The benifit is that, users may add elements on the graph multiple times, however,
	 * we only want one instance of JPanel that contains all the elements provided by users.
	 * In this case, we only return the JPanel once users finished adding elements.
	 * @return JPanel The JPanel or children class
	 */
	protected abstract JPanel getGraphPanel();
	
	/**
	 * Show up the graph on screen, the window that includes the graph is
	 * invisible by default.
	 */
	public void show() {
		frame.add(getGraphPanel());
		frame.pack();
		if(config.graph_location_x == -1 && config.graph_location_y == -1) frame.setLocationRelativeTo(null);
		else frame.setLocation(config.graph_location_x, config.graph_location_y);
		frame.setVisible(true);
	}
	
	@Override
	public void save_img(String name, String dir, String type) {
		if(img == null) {
			img = new BufferedImage(config.width, config.height, BufferedImage.TYPE_INT_RGB);
			getGraphPanel().paint(img.createGraphics());
		}
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
