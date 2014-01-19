package pl.agol.delegate.test.data;

import pl.agol.delegate.Delagate;
import pl.agol.delegate.Resource;

/**
 * 
 * @author andi
 * 
 */
@Resource
public class ValidResource {

	@Delagate
	private TestService testService;

	public void invokeServiceMethod() {

		testService.doSomeAction();
	}

	public TestService getTestService() {
		return testService;
	}
}
