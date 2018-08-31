package grapher.util;

import java.awt.Color;
import java.util.Stack;

import grapher.Config;
import util.Evaluator;

/**
 * Expression takes an expression in string format and evalute some points of the given function.
 * @author danielxu
 *
 */
public class Expression {

	/**Expression in string**/
	private String exp;
	
	/**The points that being evaluated**/
	private Point[] pts;
	
	/**Configuration**/
	private Config config;
	
	/**Function color**/
	private Color func_color;
	
	/**
	 * Setup the expression by providing it in string format. The expression has some
	 * restrictions(see {@link util.Evaluator#evaluate(String)}) and must follow the following rules:
	 * <ul>
	 * <li>Only one variable allow at this time, and it should only be 'x', does not support other letters</li>
	 * <li>No 'y=...' needed</li>
	 * </ul>
	 * Examples of valid expressions: '2+x', '3*x', '2^x'
	 * @param exp The expression in string format.
	 */
	public Expression(String exp){
		this.exp = exp;
	}
	
	/**
	 * Setup the expression by providing it in string format. And can also customize the functoin color.
	 * The expression has some restrictions(see {@link util.Evaluator#evaluate(String)})
	 * and must follow the following rules:
	 * <ul>
	 * <li>Only one variable allow at this time, and it should only be 'x', does not support other letters</li>
	 * <li>No 'y=...' needed</li>
	 * </ul>
	 * Examples of valid expressions: '2+x', '3*x', '2^x'
	 * @param exp The expression in string format.
	 * @param func_color The color of the function. Will override the global Config.func_color
	 */
	public Expression(String exp, Color color) {
		check(exp);
		this.exp = exp;
		this.func_color = color;
	}
	
	/**
	 * Apply configuration to the Expression, this method should only
	 * be accessed by GraphWindow but not other classes.
	 * @param config The Config object
	 */
	public void applyConfig(Config config){
		this.config = config;
	}
	
	/**
	 * Get the color of the function
	 * @return Color
	 */
	public Color getColor() {
		if(func_color == null){
			return config.func_color;
		}
		return func_color;
	}
	
	/**
	 * Get expression
	 * @return expression in string
	 */
	public String getExpression(){
		return exp;
	}
	
	/**
	 * Evaluate number of points of a function based on the configuration. Using
	 * {@link util.Evaluator#evaluate(String)} to evaluate the results,
	 * therefore, must obey the rules as describing in the document.
	 * @return An array that contains points of a function.
	 */
	public Point[] getPoints(){
		if(pts == null){
			int min = config.min_unit;
			int max = config.max_unit;
			// The number of units for x-axis and y-axis
			int unit = max - min;
			int density = config.density * unit;
			pts = new Point[density];
			float step = unit / (float)density;
			// Setup points
			for(int i=0;i<density;i++){
				float x = min + i * step;
				Point p = null;
				try {
					p = new Point();
					p.x = x;
					p.y = Evaluator.evaluate(exp.replace("x", "("+String.valueOf(x)+")"));
					pts[i] = p;
				}
				catch(UnsupportedOperationException e) {
					if(config.ignore_invalid) {
						p = new InvalidPoint(x);
						pts[i] = p;
					}
					else {
						throw new UnsupportedOperationException("Expression '" + toString() + "' cannot "
								+ "evaluate point with x="+x);
					}
				}
			}
		}
		return pts;
	}
	
	/**
	 * Get a single point on the expression by providing the x value
	 * @param x X value of the point
	 * @return A point that contains given x value and a calculated y value
	 */
	public Point getPoint(double x) {
		Point p = new Point();
		p.x = x;
		p.y = Evaluator.evaluate(exp.replace("x", "(" + String.valueOf(x) + ")"));
		return p;
	}
	
	/*
	 * Check if the parenthesis is symmetry or not. If yes return true, return false otherwise
	 */
	private  boolean check(String exp){
		Stack<Character> stack = new Stack<Character>();
		char c;
		for(int i=0;i<exp.length();i++){
			c = exp.charAt(i);
			if(c == '('){
				stack.push(c);
			}
			else if(c == ')'){
				if(stack.isEmpty()) return false;
				else if(stack.peek() == '('){
					stack.pop();
				}
				else return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString(){
		return exp;
	}
}
