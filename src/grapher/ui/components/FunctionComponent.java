package grapher.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import grapher.Config;
import grapher.util.Expression;

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
		// Iterate and render all points, connect them with Path
		for(int i=0;i<expressions.size();i++){
			super.render_expression(g, expressions.get(i));
		}
		renderexpressions(g);
	}
	
	private void renderexpressions(Graphics g) {
		if(config.show_expressions) {
			for(int i=0;i<expressions.size();i++) {
				Expression exp = expressions.get(i);
				Color c = exp.getColor();
				String sexp = exp.getExpression();
				g.setColor(c);
				g.drawString("y=" + sexp, 10, 15+i*15);
			}
		}
	}

}
