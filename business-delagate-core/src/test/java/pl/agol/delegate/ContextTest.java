package pl.agol.delegate;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import pl.agol.delegate.ctx.Context;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class ContextTest {

	@Test
	public void context_should_be_singleton() {

		Context ctxRefOne = Context.getContext();
		Context ctxRefTwo = Context.getContext();

		assertThat(ctxRefOne).isEqualTo(ctxRefTwo);
	}

	@Test
	public void should_fill_context_using_default_file() {

		Context ctx = Context.getContext();
		String providerClass = ctx.getProperty(Context.PROVIDER);

		assertThat(providerClass).isEqualTo("pl.agol.delegate.test.data.TestProvider");
	}

}
