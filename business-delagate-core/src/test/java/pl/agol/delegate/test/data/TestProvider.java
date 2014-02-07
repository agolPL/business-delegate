package pl.agol.delegate.test.data;

import pl.agol.delegate.provider.DelegateProvider;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class TestProvider implements DelegateProvider {

	public Object getService(String serviceName) {
		return new TestService() {
			public String doSomeAction() {
				return TestService.MESSAGE;
			}
		};
	}

}
