package exceptions;

/**
 * @author Lewis and Chase
 * 
 *         Represents the situation in which an infix expression does not have
 *         the proper form.
 */
public class ImproperPostfixExpressionException extends RuntimeException {
	/**
	 * Sets up this exception with an appropriate message.
	 */
	public ImproperPostfixExpressionException() {
		super("Improper Postfix Expression.");
	}
}
