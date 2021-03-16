package Ex0402;

/*
 * System类的方法
 * 	public static Properties getProperties()
 * 		方法用于获取当前系统的全部属性，该方法会返回一个Properties类型的容器
 * 		其中封装了系统的所有属性，这些属性是以“属性名=属性值”的形式存在的
 * 	public static String getProperty​(String key)
 * 		获取指定键（属性名）所对应的系统属性值
 */
import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
		// 获取当前系统属性
		Properties properties = System.getProperties();
		System.out.println(properties);
		// 获取所有系统属性的key（属性名），返回set对象
		Set<String> propertyNAmes = properties.stringPropertyNames();
		for (String Key : propertyNAmes) {
			// 获取当前键key（属性名）所对应的值（属性值）
			String value = System.getProperty(Key);
			System.out.println(Key + "--->" + value);
		}
	}
}
