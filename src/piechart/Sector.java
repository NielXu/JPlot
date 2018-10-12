package piechart;

import java.awt.Color;

/**
 * Sector represents a sector on the pie chart. Each sector can have different
 * color and percentage.
 * 
 * @author Daniel Xu
 *
 */
public class Sector {

    /** The percentage that this sector occupies **/
    private double percent;

    /** Color of the sector **/
    private Color c;

    /** Label, which means the sector name **/
    private String label;

    public Sector(String label, double percent, Color c) {
	this.label = label;
	this.percent = percent;
	this.c = c;
    }

    /**
     * Getter of label
     * 
     * @return The name of the sector
     */
    public String getName() {
	return label;
    }

    /**
     * Getter of percent
     * 
     * @return Get the percentage of the sector
     */
    public double getPercent() {
	return percent;
    }

    /**
     * Getter of color
     * 
     * @return Get the color of the sector
     */
    public Color getColor() {
	return c;
    }

}
