package Ex0414;

import java.util.*;

public class Ex05 {
	public static void main(String[] args) {
		Map map = new HashMap();// ����Map����
		map.put("1", "Jack");// �洢����ֵ
		map.put("2", "Rose");
		map.put("3", "Lucy");
		Set keySet = map.keySet();
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = map.get(key);// ��ȡÿ��������Ӧ��ֵ
			System.out.println(key + ":" + value);
		}
	}
}
