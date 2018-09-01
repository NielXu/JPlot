package grapher.ui.components;

import java.awt.Graphics;

import grapher.Config;

/**
 * The layout component is the component that responsible for rendering
 * axis, grids and units. It is always at the most bottom layer, so it
 * is the first component that being added.
 * @author Daniel Xu
 *
 */
public class LayoutComponent extends GraphComponent{

	public LayoutComponent(Config config) {
		super(config);
	}

	@Override
	public void render(Graphics g) {
		// Draw grids
		if(config.show_grid){
			g.setColor(config.grid_color);
			// y grid
			for(int i=0;i<=yunit;i++){
				g.drawLine(0, i*yratio, config.width, i*yratio);
			}
			// x grid
			for(int i=0;i<=xunit;i++){
				g.drawLine(i*xratio, 0, i*xratio, config.height);
			}
		}
		// Draw axis
		if(config.show_axis){
			g.setColor(config.axis_color);
			g.drawLine(0, origin_y, config.width, origin_y);
			g.drawLine(origin_x, 0, origin_x, config.height);
		}
		// Draw units
		if(config.show_unit){
			g.setColor(config.unit_color);
			// Render origin
			g.setColor(config.unit_color);
			g.fillRect(origin_x-2, origin_y-2, 4, 4);
			for(int i=0;i<=yunit;i++){
				g.fillRect(origin_x-2, i*yratio-2, 4, 4);
			}
			for(int i=0;i<=xunit;i++){
				g.fillRect(i*xratio-2, origin_y-2, 4, 4);
			}
		}
	}

}
