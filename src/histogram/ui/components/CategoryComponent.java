package histogram.ui.components;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import histogram.Bar;
import histogram.Category;
import histogram.Config;
import histogram.Section;

/**
 * Render categories at top right corner
 * 
 * @author danielxu
 *
 */
public class CategoryComponent extends HistogramComponent {

    private List<Section> section;
    private List<Category> category;

    public CategoryComponent(Config config) {
	super(config);
    }

    @Override
    public HistogramComponent addSection(List<Section> section) {
	this.section = section;
	return this;
    }

    public HistogramComponent receiveCategory(List<Category> category) {
	this.category = category;
	return this;
    }

    @Override
    public void render(Graphics g) {
	if (category == null) {
	    category = new ArrayList<Category>();
	    for (int i = 0; i < section.size(); i++) {
		Section s = section.get(i);
		List<Bar> bars = s.getBars();
		for (int j = 0; j < bars.size(); j++) {
		    Bar b = bars.get(j);
		    Category c = b.getCategory();
		    if (!category.contains(c)) {
			category.add(c);
		    }
		}
	    }
	}
	render_category(g, category);
    }

    private void render_category(Graphics g, List<Category> cs) {
	int startx = config.width - config.width * 1 / 3;
	int starty = 20;
	int offset = 0;
	for (int i = 0; i < cs.size(); i++) {
	    if (starty + i * 20 + offset >= end_y[1]) {
		startx += 125;
		offset -= i * 20;
	    }
	    Category c = cs.get(i);
	    g.setColor(c.getColor());
	    g.fillRect(startx, starty + i * 20 + offset, 20, 10);
	    g.setColor(config.categorylabel_color);
	    g.setFont(config.category_font);
	    g.drawString(c.getName(), startx + 25, starty + i * 20 + 10 + offset);
	}
    }

}
