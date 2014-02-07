package pl.agol.delegate.ctx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class Context {

	public static final String PROVIDER = "pl.agol.delegate.provider";

	private static final String DEFAULT_FILE_NAME = "delegate.properties";

	private Properties properties = new Properties();

	private Context() {
		URL delagatePropURL = this.getClass().getClassLoader().getResource(DEFAULT_FILE_NAME);
		try (FileInputStream delagateProp = new FileInputStream(delagatePropURL.getPath())) {
			properties.load(delagateProp);
		} catch (FileNotFoundException e) {
			throw new PropertiesFileNotFoundExcaption(e);
		} catch (IOException e) {
			throw new PropertiesFileIOException(e);
		}
	}

	private static class ContextHolder {
		public static final Context INSTANCE = new Context();
	}

	public static Context getContext() {
		return ContextHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
