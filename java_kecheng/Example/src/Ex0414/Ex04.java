package Ex0414;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		Map map = new HashMap();// 创建Map对象
		map.put("1", "Jack");// 存储键和值
		map.put("2", "Rose");
		map.put("3", "Lucy");
		Collection values = map.values();
		Iterator it = values.iterator();
		while (it.hasNext()) {
			Object value = it.next();
			System.out.println(value);
		}
	}
}
