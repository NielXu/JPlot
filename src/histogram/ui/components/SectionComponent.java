package histogram.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import histogram.Bar;
import histogram.Category;
import histogram.Config;
import histogram.Section;

public class SectionComponent extends HistogramComponent{

	/**Sections**/
	private List<Section> section;
	
	public SectionComponent(Config config) {
		super(config);
	}
	
	@Override
	public HistogramComponent addSection(List<Section> section) {
		this.section = section;
		return this;
	}

	@Override
	public void render(Graphics g) {
		for(int i=0;i<section.size();i++) {
			if(section.get(i) != null) {
				renderSection(g, section.get(i), starting[0] + i * xscale);
			}
		}
	}
	
	private void renderSection(Graphics g, Section s, double startx) {
		Graphics2D g2d = (Graphics2D)g;
		List<Bar> bars = s.getBars();
		List<Category> categories = new ArrayList<Category>();
		double ratio = xscale / bars.size();
		for(int i=0;i<bars.size();i++) {
			Bar b = bars.get(i);
			Category c = b.getCategory();
			if(!categories.contains(c)) {
				categories.add(c);
			}
			double value = b.getValue();
			Rectangle2D rect = new Rectangle2D.Double(startx + i * ratio, starting[1] - value * yscale,
													  ratio, value*yscale);
			g2d.setColor(c.getColor());
			g2d.fill(rect);
			if(config.show_border) {
				g2d.setColor(Color.BLACK);
				g2d.draw(rect);
			}
			if(config.show_bar_number) {
				Rectangle r = new Rectangle((int)(startx+i*ratio), (int)(starting[1]-value*yscale) - 30, 
											(int)ratio, 30);
				String text = config.barnumber_decimal.format(value * (config.yunit[1] - config.yunit[0]));
				super.renderlabel(g2d, r, config.barnumber_font, text, config.barnumber_color);
			}
		}
		if(config.show_category) {
			render_category(g, categories);
		}
	}
	
	private void render_category(Graphics g, List<Category> cs) {
		int startx = config.width - config.width*1/3;
		int starty = 20;
		int offset = 0;
		for(int i=0;i<cs.size();i++) {
			if(starty + i*20 + offset >= end_y[1]) {
				startx += 125;
				offset -= i*20;
			}
			Category c = cs.get(i);
			g.setColor(c.getColor());
			g.fillRect(startx, starty + i*20 + offset, 20, 10);
			g.setColor(config.categorylabel_color);
			g.setFont(config.category_font);
			g.drawString(c.getName(), startx+25, starty+i*20+10+offset);
		}
	}

}
