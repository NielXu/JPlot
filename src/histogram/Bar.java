package histogram;

/**
 * A vertical bar in the histogram. Each bar should have a category that it
 * belongs to.
 * 
 * @author Daniel Xu
 *
 */
public class Bar {

    /** Value of the bar **/
    private double value;

    /** The category of this bar belong to **/
    private Category category;

    /**
     * Construct a bar with given value and default bar color
     * 
     * @param d        value, which means how many y unit this bar occupy, can be a
     *                 double
     * @param category The category that this bar belong to
     */
    public Bar(double d, Category category) {
	this.value = d;
	this.category = category;
    }

    /**
     * Get the value of the bar. Value means how many y units of this vertical bar
     * contains.
     * 
     * @return Value of the bar
     */
    public double getValue() {
	return value;
    }

    /**
     * Get the category that this bar belong to
     * 
     * @return The category that this bar belong to
     */
    public Category getCategory() {
	return category;
    }

}
