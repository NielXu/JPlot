package grapher.ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.List;

import grapher.Config;
import grapher.expression.Expression;
import grapher.util.Point;

/**
 * The function component responsible for rendering the given functions. It
 * is usually on the second layer.
 * @author Daniel Xu
 *
 */
public class FunctionComponent extends GraphComponent{
	
	/**Functions that being rendered**/
	private List<Expression> expressions;

	public FunctionComponent(Config config) {
		super(config);
	}

	@Override
	public GraphComponent add_exp(List<Expression> l) {
		this.expressions = l;
		return this;
	}

	@Override
	public void render(Graphics g) {
		// Convert graphics to graphics2d
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		super.transform_to_origin(g2d);
		g2d.setColor(config.func_color);
		// Iterate and render all points, connect them with Path
		for(int i=0;i<expressions.size();i++){
			Expression exp = expressions.get(i);
			Point[] exp_pts = exp.getPoints();
			Path2D path = new Path2D.Float();
			for(int j=0;j<exp_pts.length;j++){
				Point p = exp_pts[j];
				double[] trans = translate(p.x, p.y);
				if(j==0) path.moveTo(trans[0], trans[1]);
				else path.lineTo(trans[0], trans[1]);
			}
			g2d.draw(path);
		}
		// Remember to reset origin back to normal
		g2d.setTransform(transform);
	}

}
