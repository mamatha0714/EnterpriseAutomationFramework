package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	static {
		try {
			String env = System.getProperty("env","qa");
			FileInputStream fis = new FileInputStream("src/test/resources/configs/" + env + ".properties");
			prop = new Properties();
			prop.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
		public static String getProperty(String key) {
			return prop.getProperty(key);
		}
	

}
