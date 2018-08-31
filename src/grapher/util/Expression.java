package grapher.util;

import java.awt.Color;
import java.util.Stack;

import util.Evaluator;

/**
 * Expression takes an expression in string format and evalute some points of the given function.
 * @author danielxu
 *
 */
public class Expression {

	/**Expression in string**/
	private String exp;
	
	/**Function color**/
	private Color func_color;
	
	/**Points for Grapher**/
	private Point[] graphPoint;
	
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
	 * Get the color of the function
	 * @return color of the function, null if not specified
	 */
	public Color getColor() {
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
	 * Evaluate number of points of a function. Using
	 * {@link util.Evaluator#evaluate(String)} to evaluate the results,
	 * therefore, must obey the rules as describing in the document.
	 * @param min The min value on x axis, must be an integer
	 * @param max The max value on x axis, must be an integer
	 * @param density The number of points that will be evaluated between two units
	 * @return An array that contains points of a function in range(min, max), the length
	 * will be (max-min)*density
	 */
	public Point[] getPoints(int min, int max, int density){
		Point[] pts;
		// The number of units for x-axis and y-axis
		int unit = max - min;
		density = density * unit;
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
				p = new InvalidPoint(x);
				pts[i] = p;
			}
		}
		return pts;
	}
	
	/**
	 * Similar with {@link grapher.util.Expression#getPoints(int, int, int)},
	 * this method also evaluate points between min and max. However, this
	 * method is for the {@link grapher.Grapher} to use since it only evaluates values once and
	 * then store it locally, call this method again will not affect the
	 * return value. Therefore, be caerful when calling this method, usually, 
	 * one should not call this method directly, <b>it should only be accessed by
	 * Grapher</b>
	 * @param min The min value on x axis, must be an integer
	 * @param max The max value on x axis, must be an integer
	 * @param density The number of points that will be evaluated between two units
	 * @return An array that contains points of a function in range(min, max), the length
	 * will be (max-min)*density
	 */
	public Point[] getGraphPoints(int min, int max, int density) {
		if(graphPoint == null) {
			// The number of units for x-axis and y-axis
			int unit = max - min;
			density = density * unit;
			graphPoint = new Point[density];
			float step = unit / (float)density;
			// Setup points
			for(int i=0;i<density;i++){
				float x = min + i * step;
				Point p = null;
				try {
					p = new Point();
					p.x = x;
					p.y = Evaluator.evaluate(exp.replace("x", "("+String.valueOf(x)+")"));
					graphPoint[i] = p;
				}
				catch(UnsupportedOperationException e) {
					p = new InvalidPoint(x);
					graphPoint[i] = p;
				}
			}
		}
		return graphPoint;
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
