package Ex0409;

import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
		HashSet set = new HashSet();// 创建HashSet集合
		set.add("Jack");// 向该Set集合中添加字符串
		set.add("Eve");
		set.add("Rose");
		set.add("Rose");// 向该Set集合中添加重复元素
		Iterator it = set.iterator();// 获取Iterator对象
		while (it.hasNext()) {// 通过while循环，判断集合中是否由元素
			Object obj = it.next();
			System.out.println(obj);
		}
	}
}
