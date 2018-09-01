package grapher.ui.components;

import java.awt.Graphics;

import grapher.Config;

/**
 * The axis numbers component is responsible for rendering the numbers on the axis. It
 * is usually on top of the layout component and it is disbaled by default.
 * @author Daniel Xu
 *
 */
public class AxisNumbersComponent extends GraphComponent{

	public AxisNumbersComponent(Config config) {
		super(config);
	}

	@Override
	public void render(Graphics g) {
		if(config.show_numbers) {
			g.setColor(config.number_color);
			for(int i=0;i<=xunit;i++) {
				// Only render origin once
				if(config.x_min + i == 0) {g.drawString(String.valueOf(config.x_min+i), i*xratio, origin_y);}
				else{
					g.drawString(String.valueOf(config.x_min+i), i*xratio, origin_y);
				}
			}
			for(int i=0;i<=yunit;i++) {
				if(config.y_min + i != 0) {
					g.drawString(String.valueOf(config.y_min+i), origin_x+2, config.height - (i*yratio-1));
				}
			}
		}
	}
}
