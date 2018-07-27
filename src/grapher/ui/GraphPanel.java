package grapher.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JPanel;

import grapher.Config;
import grapher.expression.Expression;
import grapher.util.Point;

/**
 * The GraphPanel is the JPanel that responsible for drawing
 * the function.
 * @author danielxu
 *
 */
class GraphPanel extends JPanel{
	
	/**Default serial id**/
	private static final long serialVersionUID = 1L;
	
	/**Expressions**/
	private List<Expression> expressions;
	/**Points**/
	private List<Point> points;
	
	/**Configuration**/
	private Config config;

	
	/**The number of units for x-axis and y-axis**/
	int unit;
	/**Ratio between x,y and pixels**/
	int ratio;
	/**Origin x,y**/
	int origin_x, origin_y;

	/**
	 * Construct the graphpanel, all the rendering are done here.
	 * @param points The points that rendered on screen
	 * @param expressions The funtions that rendered on screen
	 * @param config Configuration
	 */
	public GraphPanel(List<Point> points, List<Expression> expressions, Config config){
		super();
		setPreferredSize(new Dimension(config.size, config.size));
		this.expressions = expressions;
		this.config = config;
		this.points = points;
		init();
	}
	
	// Initialize some of the important values
	private void init(){
		unit = config.max_unit - config.min_unit;
		ratio = config.size / unit;
		origin_x = -config.min_unit * ratio;
		origin_y = config.size - origin_x;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// Background color rendering
		g.setColor(config.background_color);
		g.fillRect(0, 0, config.size, config.size);
		// Rendering axis
		render_layouts(g);
		// Render numbers
		render_numbers(g);
		// Render functions
		render_functions(g);
		// Render points
		render_points(g);
	}
	
	// Draw points on the panel
	private void render_points(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(config.point_color);
		Path2D path = new Path2D.Float();
		for(int i=0;i<points.size();i++){
			Point p = points.get(i);
			Rectangle2D rect = new Rectangle2D.Float();
			double[] trans = translate(p.x, p.y);
			rect.setRect(trans[0]-2, trans[1]-2, 4, 4);
			g2d.fill(rect);
			if(i==0) path.moveTo(trans[0], trans[1]);
			else path.lineTo(trans[0], trans[1]);
		}
		if(config.link_points) g2d.draw(path);
	}
	
	// Draw functions on the panel
	private void render_functions(Graphics g){
		// Convert graphics to graphics2d
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(origin_x, origin_y);
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
	}
	
	// Translate x and y values to pixels on the panel
	private double[] translate(double x, double y){
		return new double[]{x*ratio, -y*ratio};
	}
	
	// Draw numbers on axises
	private void render_numbers(Graphics g) {
		if(config.show_numbers) {
			g.setColor(config.number_color);
			for(int i=0;i<unit;i++) {
				if(config.min_unit + i == 0) {g.drawString(String.valueOf(config.min_unit+i), i*ratio, origin_y);}
				else{
					g.drawString(String.valueOf(config.min_unit+i), i*ratio, origin_y);
					g.drawString(String.valueOf(config.min_unit+i), origin_x-2, i*ratio-2);
				}
			}
		}
	}
	
	// Draw axis on the panel
	private void render_layouts(Graphics g){
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