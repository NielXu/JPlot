package piechart.ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.List;

import piechart.Config;
import piechart.Sector;

/**
 * SectorComponent is responsible for rendering the main chart
 * at the center
 * @author Daniel Xu
 *
 */
public class SectorComponent extends PieComponent{
	
	/**List of sectors**/
	private List<Sector> sectors;
	
	public SectorComponent(Config config) {
		super(config);
	}
	
	@Override
	public PieComponent addSector(List<Sector> sectors) {
		this.sectors = sectors;
		return this;
	}

	@Override
	public void render(Graphics g) {
		renderSector(g);
		renderlabel(g);
	}
	
	private void renderSector(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		double last = 0;
		for(Sector s : sectors) {
			double ratio = s.getPercent() * 360;
			g2d.setColor(s.getColor());
			Arc2D arc = new Arc2D.Double((double)super.chart_x, (double)super.chart_y,
										 (double)super.chart_size, (double)super.chart_size,
										 last, ratio, Arc2D.PIE);
			g2d.fill(arc);
			last += ratio;
		}
	}
	
	private void renderlabel(Graphics g) {
		if(config.show_label) {
			int startx = 15;
			int starty = super.chart_x + super.chart_size;
			int offset = 35;
			g.setFont(config.sectorlabel_font);
			for(int i=0;i<sectors.size();i++) {
				Sector s = sectors.get(i);
				String name = s.getName() + " (%" + (s.getPercent() * 100) + ")";
				int name_width = g.getFontMetrics().stringWidth(name);
				if(startx + name_width >= config.width) {
					startx = 15;
					starty += 20;
				}
				g.setColor(s.getColor());
				g.fillRect(startx, starty, 20, 10);
				g.setColor(config.sectorlabel_color);
				g.drawString(name, startx + 20 + 5, starty+10);
				startx += name_width + offset + 20;
			}
		}
	}

}
