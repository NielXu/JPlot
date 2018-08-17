package grapher.ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import grapher.Config;
import grapher.util.Buffer;
import grapher.util.Point;

/**
 * The point component reponsible for rendering points and lines that link them together.
 * @author Daniel Xu
 *
 */
public class PointComponent extends GraphComponent{

	/**Points that being rendered**/
	private List<Buffer> points;
	
	public PointComponent(Config config) {
		super(config);
	}
	
	@Override
	public GraphComponent add_pts(List<Buffer> l) {
		this.points = l;
		return this;
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		super.transform_to_origin(g2d);
		for(int i=0;i<points.size();i++){
			Buffer b = points.get(i);
			Path2D path = new Path2D.Float();
			g2d.setColor(b.getColor());
			for(int j=0;j<b.getPoints().length;j++) {
				Point p = b.getPoints()[j];
				Rectangle2D rect = new Rectangle2D.Float();
				double[] trans = translate(p.x, p.y);
				rect.setRect(trans[0]-2, trans[1]-2, 4, 4);
				g2d.fill(rect);
				if(j==0) path.moveTo(trans[0], trans[1]);
				else path.lineTo(trans[0], trans[1]);
			}
			if(config.link_points) g2d.draw(path);
		}
		g2d.setTransform(transform);
	}

}
