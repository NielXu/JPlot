package trend.ui;

import java.util.ArrayList;
import java.util.List;

import common.RenderPanel;
import histogram.Category;
import histogram.ui.components.CategoryComponent;
import histogram.ui.components.LayoutComponent;
import trend.Config;
import trend.Trend;
import trend.ui.components.TrendComponent;

/**
 * JPanel that contains rendering contents
 * 
 * @author Daniel Xu
 *
 */
public class TrendPanel extends RenderPanel {

    public TrendPanel(Config config, List<Trend> trends) {
	super(config);
	super.addRenderable(new LayoutComponent(config));
	super.addRenderable(new TrendComponent(config).addTrend(trends));
	// Add all categories to a list and reuse the CategoryComponent from Histogram
	List<Category> category = new ArrayList<Category>();
	for (int i = 0; i < trends.size(); i++) {
	    Category c = trends.get(i).getCategory();
	    if (!category.contains(c)) {
		category.add(c);
	    }
	}
	super.addRenderable(new CategoryComponent(config).receiveCategory(category));
    }

}
