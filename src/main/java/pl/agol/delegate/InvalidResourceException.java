package pl.agol.delegate;

/**
 * 
 * @author andi
 * 
 */
public class InvalidResourceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidResourceException(String message, Class<?> clazz) {
		super("Use " + Resource.class + " to annotate class");
	}
}
