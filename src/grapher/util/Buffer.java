package grapher.util;

import java.awt.Color;

/**
 * A small buffer class that stores points information and their color
 * @author Daniel Xu
 *
 */
public class Buffer {
	private Color c;
	private Point[] p;
	private int s;
	
	/**
	 * @param p Array with Point
	 * @param c Color of points
	 * @param s Size of points
	 */
	public Buffer(Point[] p, Color c, int s) {
		this.p = p;
		this.c = c;
		this.s = s;
	}
	
	public int getSize() {return s;}
	
	public Point[] getPoints() {return p;}
	
	public Color getColor() {return c;}
}
