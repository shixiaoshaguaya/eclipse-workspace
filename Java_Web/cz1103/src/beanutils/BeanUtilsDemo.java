package beanutils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsDemo {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "jack");
		BeanUtils.setProperty(p, "age", 10);
		String name = BeanUtils.getProperty(p, "name");
		String age = BeanUtils.getProperty(p, "age");
		System.out.println("我的名字是" + name + ",我今年" + age + "岁了！");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "张三");
		map.put("age", 10);
		BeanUtils.populate(p, map);
		System.out.println("姓名：" + p.getName() + ",年龄：" + p.getAge());
	}
}
