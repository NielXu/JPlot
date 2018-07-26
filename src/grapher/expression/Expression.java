package grapher.expression;

import java.util.Stack;

import grapher.Config;
import grapher.util.Point;

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
	
	/**
	 * Setup the expression by providing it in string format. The expression has some
	 * restrictions(see {@link grapher.expression.Evaluator#evaluate(String)}) and must follow the following rules:
	 * <ul>
	 * <li>Only one variable allow at this time, and it should only be 'x', does not support other letters</li>
	 * <li>No 'y=...' needed</li>
	 * </ul>
	 * Examples of valid expressions: '2+x', '3*x', '2^x'
	 * @param exp The expression in string format.
	 */
	public Expression(String exp){
		check(exp);
		this.exp = exp;
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
	 * Get expression
	 * @return expression in string
	 */
	public String getExpression(){
		return exp;
	}
	
	/**
	 * Evaluate number of points of a function based on the configuration. Using
	 * {@link grapher.expression.Evaluator#evaluate(String)} to evaluate the results,
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
				Point p = new Point();
				float x = min + i * step;
				p.x = x;
				p.y = (float) Evaluator.evaluate(exp.replace("x", "("+String.valueOf(x)+")"));
				pts[i] = p;
			}
		}
		return pts;
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
