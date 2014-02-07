package pl.agol.delegate;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class InvalidResourceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidResourceException(Class<?> clazz) {
		super("Use " + Resource.class + " to annotate class");
	}
}
