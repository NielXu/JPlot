package grapher.util;

import java.awt.Color;

import grapher.Config;

/**
 * A small buffer class that stores points information and their color
 * @author Daniel Xu
 *
 */
public class Buffer {
	private Color c;
	private Config f;
	private Point[] p;
	
	public Buffer(Point[] p, Config f, Color c) {
		this.p = p;
		this.f = f;
		this.c = c;
	}
	
	public Point[] getPoints() {return p;}
	
	public Color getColor() {
		if(c == null) return f.point_color;
		else return c;
	}
}
