package pl.agol.delegate;

/**
 * 
 * @author andi
 * 
 */
public class ClientFactory {

	public static <T> T buildClient(Class<T> clientClass) {

		return null;
	}

	public static <T> T buildClient(T clientObject) {

		return clientObject;
	}
}
