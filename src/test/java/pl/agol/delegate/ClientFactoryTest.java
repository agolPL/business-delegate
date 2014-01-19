package pl.agol.delegate;

import static org.fest.assertions.Assertions.*;

import org.testng.annotations.Test;

import pl.agol.delegate.test.data.InvalidResource;
import pl.agol.delegate.test.data.ValidResource;

/**
 * 
 * @author andi
 * 
 */
public class ClientFactoryTest {

	@Test
	public void should_build_client_from_class() {

		ValidResource resource = ResourceFactory.build(ValidResource.class);

		assertThat(resource)
			.isNotNull();
	}

	@Test
	public void should_build_client_using_existing_object() {

		ValidResource resource = new ValidResource();
		resource = ResourceFactory.build(resource);
		
		assertThat(resource)
			.isNotNull()
			.isEqualTo(resource);
	}
	
	@Test(expectedExceptions = InvalidResourceException.class)
	public void should_throw_InvalidClientException_while_building_client_from_class() {
		
		ResourceFactory.build(InvalidResource.class);
	}
	
	@Test(expectedExceptions = InvalidResourceException.class)
	public void should_throw_InvalidClientException_while_building_client_using_existing_object() {
		
		ResourceFactory.build(new InvalidResource());
	}
}
