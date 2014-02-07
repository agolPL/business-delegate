package pl.agol.delegate;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class InjectionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InjectionException(Class<?> resourceClass, Class<?> injectClass, Throwable cause) {
		super("Couldn't inject " + resourceClass + " to " + resourceClass, cause);
	}
}
