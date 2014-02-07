package pl.agol.delegate.provider;

import pl.agol.delegate.ctx.Context;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class DelagateProviderFactory {

	@SuppressWarnings("unchecked")
	public static DelegateProvider build() {
		try {
			Context ctx = Context.getContext();
			String providerClassName = ctx.getProperty(Context.PROVIDER);
			Class<DelegateProvider> delagateProviderClass;
			delagateProviderClass = (Class<DelegateProvider>) Class.forName(providerClassName);
			return delagateProviderClass.newInstance();
		} catch (ClassNotFoundException e) {
			throw new DelegateProviderClassNotFoundExcaption(e);
		} catch (InstantiationException e) {
			throw new InstantiationDelagateProviderException(e);
		} catch (IllegalAccessException e) {
			throw new InstantiationDelagateProviderException(e);
		}

	}

}
