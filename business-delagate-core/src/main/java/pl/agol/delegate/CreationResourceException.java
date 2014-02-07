package pl.agol.delegate;

/**
 * 
 * @author Andrzej Goławski
 *
 */
public class CreationResourceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CreationResourceException(Class<?> ResourceClass, Throwable cause) {
		super("Couldn't create resource: " + ResourceClass, cause);
	}
}
