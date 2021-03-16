package Ex0414;

import java.util.*;

public class Ex06 {
	public static void main(String[] args) {
		Properties p = new Properties(); //创建Properties对象
		p.setProperty("Backgroup-color", "red");
		p.setProperty("Font-size", "14px");
		p.setProperty("Language", "chinese");
		Enumeration names = p.propertyNames();
		while (names.hasMoreElements()) {// 循环遍历所有的键
			String key = (String) names.nextElement();
			String value = p.getProperty(key);// 获取对应键的值
			System.out.println(key + "=" +value);
		}
	}
}
