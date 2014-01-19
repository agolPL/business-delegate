package pl.agol.delegate.test.data;

import pl.agol.delegate.provider.DelegateProvider;

/**
 * 
 * @author andi
 * 
 */
public class TestProvider implements DelegateProvider {

	public Object getService() {
		return new TestService() {
			public String doSomeAction() {
				return TestService.MESSAGE;
			}
		};
	}

}
