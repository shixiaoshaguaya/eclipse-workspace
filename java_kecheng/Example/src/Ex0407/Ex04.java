package Ex0407;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); // 创建ArrayList集合
		list.add("Jack"); // 向集合中添加字符串元素
		list.add("Rose");
		list.add("Tom");
		for (Object obj : list) {// 使用foreach循环遍历集合
			System.out.println(obj);// 取出并打印集合中的元素
		}
	}
}
