package grapher.ui;

import java.util.List;

import common.RenderPanel;
import grapher.Config;
import grapher.ui.components.AxisNumbersComponent;
import grapher.ui.components.CursorComponent;
import grapher.ui.components.FunctionComponent;
import grapher.ui.components.LayoutComponent;
import grapher.ui.components.PointComponent;
import grapher.ui.components.listener.MotionListener;
import grapher.util.Buffer;
import grapher.util.Expression;

/**
 * The GraphPanel is the JPanel that responsible for rendering
 * 
 * @author danielxu
 *
 */
public class GraphPanel extends RenderPanel {

    /**
     * Construct the graphpanel, all the rendering are done here.
     * 
     * @param points      The points that rendered on screen
     * @param expressions The funtions that rendered on screen
     * @param config      Configuration
     */
    public GraphPanel(List<Buffer> points, List<Expression> expressions, Config config) {
	super(config);
	super.addRenderable(new LayoutComponent(config));
	super.addRenderable(new AxisNumbersComponent(config));
	super.addRenderable(new FunctionComponent(config).add_exp(expressions));
	super.addRenderable(new PointComponent(config).add_pts(points));
	// Cursor component is special since it requires motion listener
	CursorComponent cursorCompo = new CursorComponent(config);
	addMouseMotionListener(new MotionListener(this, cursorCompo));
	super.addRenderable(cursorCompo);
    }
}