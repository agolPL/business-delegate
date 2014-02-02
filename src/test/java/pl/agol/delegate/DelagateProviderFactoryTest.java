package pl.agol.delegate;

import org.fest.assertions.Assertions;
import org.testng.annotations.Test;

import pl.agol.delegate.provider.DelagateProviderFactory;
import pl.agol.delegate.provider.DelegateProvider;
import pl.agol.delegate.test.data.TestProvider;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class DelagateProviderFactoryTest {

	@Test
	public void should_build_TestProvider() {

		DelegateProvider delegateProvider = DelagateProviderFactory.build();

		Assertions.assertThat(delegateProvider).isInstanceOf(TestProvider.class);
	}
}
