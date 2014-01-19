package pl.agol.delegate;

/**
 * 
 * @author andi
 * 
 */
public class ResourceFactory {

	public static <T> T build(Class<T> resourceClass) {

		return null;
	}

	public static <T> T build(T resourceObject) {

		return resourceObject;
	}
}
