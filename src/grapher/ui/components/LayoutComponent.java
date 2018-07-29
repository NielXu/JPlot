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
			for(int i=0;i<=unit;i++){
				g.drawLine(0, i*ratio, config.size, i*ratio);
			}
			for(int i=0;i<=unit;i++){
				g.drawLine(i*ratio, 0, i*ratio, config.size);
			}
		}
		// Draw axis
		if(config.show_axis){
			g.setColor(config.axis_color);
			g.drawLine(0, origin_y, config.size, origin_y);
			g.drawLine(origin_x, 0, origin_x, config.size);
			// Render origin
			g.setColor(config.unit_color);
			g.fillRect(origin_x-2, origin_y-2, 4, 4);
		}
		// Draw units
		if(config.show_unit){
			g.setColor(config.unit_color);
			for(int i=0;i<unit;i++){
				g.fillRect(i*ratio-2, origin_y-2, 4, 4);
				g.fillRect(origin_x-2, i*ratio-2, 4, 4);
			}
		}
	}

}
