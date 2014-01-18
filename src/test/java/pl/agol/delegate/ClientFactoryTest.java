package pl.agol.delegate;

import static org.fest.assertions.Assertions.*;
import org.testng.annotations.Test;

import pl.agol.delegate.test.data.TestClient;

/**
 * 
 * @author andi
 * 
 */
public class ClientFactoryTest {

	@Test
	public void shouldBuildClientFromClassTest() {

		TestClient testClient = ClientFactory.buildClient(TestClient.class);

		assertThat(testClient)
			.isNotNull();
	}

	@Test
	public void shouldBuildClientFromObject() {

		TestClient testClient = new TestClient();
		testClient = ClientFactory.buildClient(testClient);
		
		assertThat(testClient)
			.isNotNull()
			.isEqualTo(testClient);
	}
}
