package util;

import java.util.Stack;

/**
 * Evaluator is a power class that read string and evluate the result of the
 * string. It is a static class, therefore, no instance needed.
 * 
 * @author danielxu
 *
 */
public class Evaluator {

    private Evaluator() {
    }

    /**
     * Do the calculation and return the double as the result. <b>The operators in
     * the expression cannot be omitted, otherwise the result will be wrong or the
     * evaluation will fail.</b> Spaces are allowed in the experssion since they
     * will be removed in the calculation process.<br>
     * <br>
     * 
     * Accept operations: (), +, -, *, /, ^, abs(), sin(), cos(), ln(), lg()<br>
     * Accept special numbers: pi, e<br>
     * <br>
     * 
     * Special cases:
     * <ul>
     * <li>If the degree is not an integer, it should be written as a^(1/2)</li>
     * <li>If the degree is negative, it should be written as a^(-2) but not
     * a^-2</li>
     * </ul>
     * 
     * @param exp - The expression, such as "1+1"
     * @return The result in double
     */
    public static double evaluate(String exp) {
	// if(exp == null || exp.equals("")) throw new ExpressionException("Expression
	// cannot be null or empty");
	// if(!check(exp)) throw new ExpressionException("Parenthesis missing in the
	// expression");

	// Repalce whitespaces and some special notations
	exp = exp.replace(" ", "");
	exp = exp.replace("E-", "1/10^"); // Replace E-n to 1/10^n, this will happen when the number is really small
	exp = exp.replace("sin(", "~"); // Replace sin( to ~
	exp = exp.replace("cos(", "&"); // Replace cos( to &
	exp = exp.replace("tan(", "@"); // Repalce tan( to @
	exp = exp.replace("abs(", "`"); // Replace abs( to `
	exp = exp.replace("ln(", "%"); // Replace ln( to %
	exp = exp.replace("lg(", "#"); // Replace lg( to #
	exp = exp.replace("e", String.valueOf(Math.E)); // Replace 'e' to natural number e
	exp = exp.replace("pi", String.valueOf(Math.PI));// Replace 'pi' to pi
	// Modify -x to 0-x
	for (int i = 0; i < exp.length(); i++) {
	    if (exp.charAt(i) == '-') {
		if (i == 0) {
		    exp = "0" + exp;
		} else {
		    if (exp.charAt(i - 1) == '(') {
			String sub1 = exp.substring(0, i);
			String sub2 = exp.substring(i, exp.length());
			String n = sub1 + "0" + sub2;
			exp = n;
		    }
		}
	    }
	}

	char[] tokens = exp.toCharArray();
	Stack<Character> ops = new Stack<Character>(); // Operations stack
	Stack<Double> vals = new Stack<Double>(); // Values stack

	for (int i = 0; i < tokens.length; i++) {
	    // If it is a number, push it to the value stack
	    if (tokens[i] >= '0' && tokens[i] <= '9') {
		StringBuilder sb = new StringBuilder();

		while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')) {
		    sb.append(tokens[i++]);
		}
		i--;
		vals.push(Double.parseDouble(sb.toString()));
	    }
	    // If it is (, push it onto the operations stack
	    else if (tokens[i] == '(' || tokens[i] == '~' || tokens[i] == '&' || tokens[i] == '@' || tokens[i] == '`'
		    || tokens[i] == '#' || tokens[i] == '%') {
		ops.push(tokens[i]);
	    }
	    // If it is ), find the closest ( to solve
	    else if (tokens[i] == ')') {
		while (ops.peek() != '(') {
		    // If it is a sin operator
		    if (ops.peek() == '~') {
			double val = vals.pop();
			vals.push(Math.sin(val));
			break;
		    }
		    // If it is a cos operator
		    else if (ops.peek() == '&') {
			double val = vals.pop();
			vals.push(Math.cos(val));
			break;
		    }
		    // If it is a tan operator
		    else if (ops.peek() == '@') {
			double val = vals.pop();
			vals.push(Math.tan(val));
			break;
		    }
		    // If it is abs operator
		    else if (ops.peek() == '`') {
			double val = vals.pop();
			vals.push(Math.abs(val));
			break;
		    }
		    // If it is a ln operator
		    else if (ops.peek() == '%') {
			double val = vals.pop();
			vals.push(Math.log(val));
			break;
		    }
		    // If it is a lg operator
		    else if (ops.peek() == '#') {
			double val = vals.pop();
			vals.push(Math.log10(val));
			break;
		    } else if (!ops.isEmpty() && !vals.empty() && vals.size() > 1) {
			vals.push(operation(ops.pop(), vals.pop(), vals.pop())); // Do the operation, push the result to
										 // the value stack
		    }
		}
		ops.pop();
	    }
	    // If it is the operator
	    else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
		while (!ops.empty() && ops.peek() != '~' && ops.peek() != '&' && ops.peek() != '@' && ops.peek() != '`'
			&& ops.peek() != '#' && ops.peek() != '%' && hasPrecedence(tokens[i], ops.peek())) {
		    vals.push(operation(ops.pop(), vals.pop(), vals.pop()));
		}

		// Push current token to 'ops'.
		ops.push(tokens[i]);
	    }
	}
	// Do the final operation
	while (!ops.empty()) {
	    vals.push(operation(ops.pop(), vals.pop(), vals.pop()));
	}
	// Return the final value
	return vals.pop();
    }

    /*
     * Returns true if 'op2' has higher or same precedence as 'op1', otherwise
     * returns false. (^) > (/ *) > (+ -)
     */
    private static boolean hasPrecedence(char op1, char op2) {
	if (op2 == '(' || op2 == ')')
	    return false;
	if ((op1 == '^') && (op2 == '+' || op2 == '-' || op2 == '*' || op2 == '/'))
	    return false;
	if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
	    return false;
	else
	    return true;
    }

    /*
     * Apply the operation according to the operator
     */
    private static double operation(char op, double val1, double val2) {
	switch (op) {
	case '+':
	    return val2 + val1;
	case '-':
	    return val2 - val1;
	case '*':
	    return val2 * val1;
	case '/':
	    if (val1 == 0)
		throw new UnsupportedOperationException("Cannot divide by zero");
	    return val2 / val1;
	case '^':
	    return Math.pow(val2, val1);
	}
	return 0;
    }

}
