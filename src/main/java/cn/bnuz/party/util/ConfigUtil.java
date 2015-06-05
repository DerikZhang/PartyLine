package cn.bnuz.party.util;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class ConfigUtil {

	private  Properties prop;
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public ConfigUtil() {
		prop = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/config.properties");
		try {
			prop.load(in);
				} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	@Before
//	public void init() {
//		prop = new Properties();
//		InputStream in = Object.class.getResourceAsStream("/config.properties");
//		try {
//			prop.load(in);
//				} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	public String getProperties(String key){
		return getProp().getProperty(key);
	}

	@Test
	public void testCase(){
		System.out.println("accountSid="+prop.getProperty("accountSid"));
		System.out.println("authToken="+prop.getProperty("authToken"));
		System.out.println("appId="+prop.getProperty("appId"));
		System.out.println("templateId="+prop.getProperty("templateId"));
		System.out.println("to="+prop.getProperty("to"));
	}
}
