package grapher.ui.components;

import java.awt.Graphics;

import grapher.Config;

/**
 * The cursor component responsible for rendering the cursor to a small rectangle
 * and showing x,y values on the top left corner. It requires MotionListener, therefore,
 * it is a bit different from other components
 * @author Daniel Xu
 *
 */
public class CursorComponent extends GraphComponent{

	/**The cursor location, out of screen by default**/
	private int cursor_x = -5, cursor_y = -5;
	
	public CursorComponent(Config config) {
		super(config);
	}

	@Override
	public void render(Graphics g) {
		if(config.show_cursorxy) {
			g.setColor(config.cursorlocation_color);
			g.fillRect(cursor_x-2, cursor_y-2, 4, 4);
			double[] trans = super.re_translate(cursor_x, cursor_y);
			g.drawString("x = "+config.cursorlocation_decimal.format(trans[0]), 5, 15);
			g.drawString("y = "+config.cursorlocation_decimal.format(trans[1]), 5, 28);
		}
	}
	
	/**
	 * Set cursor location in x,y values(in pixels)
	 * @param x x value
	 * @param y y value
	 */
	public void set_cursorlocation(int x, int y) {
		this.cursor_x = x;
		this.cursor_y = y;
	}

}
