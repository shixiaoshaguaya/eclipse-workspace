package Ex0407;

import java.util.ArrayList;

public class Ex01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();// 创建ArrayList集合
		list.add("stu1");// 向集合中添加元素
		list.add("stu2");
		list.add("stu3");
		list.add("stu4");
		System.out.println("集合的长度："+ list.size());
		System.out.println("第2个元素是："+ list.get(1));
	}
}
