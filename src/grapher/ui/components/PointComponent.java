package grapher.ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
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
	private List<Buffer> buffers;
	
	public PointComponent(Config config) {
		super(config);
	}
	
	@Override
	public GraphComponent add_pts(List<Buffer> l) {
		this.buffers = l;
		return this;
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		super.transform_to_origin(g2d);
		for(int i=0;i<buffers.size();i++){
			Buffer b = buffers.get(i);
			int size = b.getSize();
			Path2D path = new Path2D.Float();
			g2d.setColor(b.getColor());
			for(int j=0;j<b.getPoints().length;j++) {
				Point p = b.getPoints()[j];
				double[] trans = translate(p.x, p.y);
				Shape s;
				if(config.point_cicrle) {
					s = new Ellipse2D.Double(trans[0]-(size/2), trans[1]-(size/2), size, size);
				}
				else {
					s= new Rectangle2D.Double(trans[0]-(size/2), trans[1]-(size/2), size, size);
				}
				g2d.fill(s);
				if(j==0) path.moveTo(trans[0], trans[1]);
				else path.lineTo(trans[0], trans[1]);
			}
			if(config.link_points) g2d.draw(path);
		}
		g2d.setTransform(transform);
	}

}
