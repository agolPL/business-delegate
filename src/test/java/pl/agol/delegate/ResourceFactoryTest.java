package pl.agol.delegate;

import static org.fest.assertions.Assertions.*;

import org.testng.annotations.Test;

import pl.agol.delegate.test.data.InvalidResource;
import pl.agol.delegate.test.data.TestService;
import pl.agol.delegate.test.data.ValidResource;

/**
 * 
 * @author andi
 * 
 */
public class ResourceFactoryTest {

	@Test
	public void should_build_resource_from_class() {

		ValidResource resource = ResourceFactory.build(ValidResource.class);

		assertThat(resource)
			.isNotNull();
	}

	@Test
	public void should_build_resource_using_existing_object() {

		ValidResource resource = new ValidResource();
		resource = ResourceFactory.build(resource);
		
		assertThat(resource)
			.isNotNull()
			.isEqualTo(resource);
	}
	
	@Test(expectedExceptions = InvalidResourceException.class)
	public void should_throw_InvalidClientException_while_building_resource_from_class() {
		
		ResourceFactory.build(InvalidResource.class);
	}
	
	@Test(expectedExceptions = InvalidResourceException.class)
	public void should_throw_InvalidClientException_while_building_resource_using_existing_object() {
		
		ResourceFactory.build(new InvalidResource());
	}
	
	@Test
	public void should_inject_TestService() {
	
		ValidResource resource = ResourceFactory.build(ValidResource.class);
		TestService testService = resource.getTestService();
		
		assertThat(testService)
			.isNotNull();
		
		assertThat(testService.doSomeAction())
			.isEqualTo(TestService.MESSAGE);
	}
}
