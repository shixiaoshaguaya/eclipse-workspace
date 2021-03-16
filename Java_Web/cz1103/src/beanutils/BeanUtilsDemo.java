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
		System.out.println("�ҵ�������" + name + ",�ҽ���" + age + "���ˣ�");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "����");
		map.put("age", 10);
		BeanUtils.populate(p, map);
		System.out.println("������" + p.getName() + ",���䣺" + p.getAge());
	}
}
