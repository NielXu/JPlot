package histogram;

import java.awt.Color;

/**
 * The category of the vertical bar, each category can have
 * different color
 * @author Daniel Xu
 *
 */
public class Category {
	
	/**The color represents the category**/
	private Color c;
	
	/**Category name**/
	private String name;
	
	/**
	 * Get a default category with default bar color in config
	 * @return A default category
	 */
	public static Category defaultCategory() {
		return new Category("Default", new Config().bar_color);
	}
	
	/**
	 * Construct a new category, with name and color
	 * @param name Name of the category
	 * @param c The color represents the category
	 */
	public Category(String name, Color c) {
		this.name = name;
		this.c = c;
	}
	
	/**
	 * Get the color of the category
	 * @return Color of the category
	 */
	public Color getColor() {
		return c;
	}
	
	/**
	 * Get the name of the catagory
	 * @return Name of the category
	 */
	public String getName() {
		return name;
	}
}
