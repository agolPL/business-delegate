package pl.agol.delegate;

import java.lang.reflect.Field;

import pl.agol.delegate.provider.DelagateProviderFactory;
import pl.agol.delegate.provider.DelegateProvider;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class ResourceFactory {

	private final DelegateProvider delegateProvider;

	private ResourceFactory() {
		delegateProvider = DelagateProviderFactory.build();
	}

	private <T> T instantiateResourceAndInjectDelagates(Class<T> resourceClass) {
		T resource = instantiateResource(resourceClass);
		return injectDelagates(resource);
	}

	private <T> T instantiateResource(Class<T> resourceClass) {
		try {
			T resource = resourceClass.newInstance();
			return resource;
		} catch (Exception e) {
			throw new CreationResourceException(resourceClass, e);
		}
	}

	private <T> T injectDelagates(T resourceObject) {
		for (Field field : resourceObject.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Delagate.class)) {
				injectDelagate(resourceObject, field);
			}
		}
		return resourceObject;
	}

	private void injectDelagate(Object resourceObject, Field field) {
		String serviceName = field.getAnnotation(Delagate.class).name();
		Object service = delegateProvider.getService(serviceName);
		field.setAccessible(true);
		try {
			field.set(resourceObject, service);
		} catch (Exception e) {
			throw new InjectionException(resourceObject.getClass(), service.getClass(), e);
		}
	}

	public static <T> T build(Class<T> resourceClass) {
		checkResource(resourceClass);
		return new ResourceFactory().instantiateResourceAndInjectDelagates(resourceClass);
	}

	private static void checkResource(Class<?> resourceClass) {
		if (!resourceClass.isAnnotationPresent(Resource.class)) {
			throw new InvalidResourceException(resourceClass);
		}
	}

	public static <T> T build(T resourceObject) {
		checkResource(resourceObject.getClass());
		return new ResourceFactory().injectDelagates(resourceObject);
	}

}
