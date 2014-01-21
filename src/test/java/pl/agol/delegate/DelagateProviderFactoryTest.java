package pl.agol.delegate;

import org.fest.assertions.Assertions;
import org.testng.annotations.Test;

import pl.agol.delegate.provider.DelagateProviderFactory;
import pl.agol.delegate.provider.DelegateProvider;
import pl.agol.delegate.test.data.TestProvider;

/**
 * 
 * @author andi
 * 
 */
public class DelagateProviderFactoryTest {

	@Test
	public void schould_bild_TestProvider() {

		DelegateProvider delegateProvider = DelagateProviderFactory.build();

		Assertions.assertThat(delegateProvider).isInstanceOf(TestProvider.class);
	}
}
