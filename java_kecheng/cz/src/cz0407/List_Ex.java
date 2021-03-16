package cz0407;

import java.util.ArrayList;
import java.util.LinkedList;

public class List_Ex {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("郑海彬");
		list.add("沈晓毅");
		list.add("黄志翔");
		list.add("黄焱荣");
		System.out.println("ArrayList集合："+list);
		System.out.println("集合的长度："+ list.size());
		System.out.println("第3个元素是："+ list.get(2));
		LinkedList link = new LinkedList();
		link.add("黄焱荣");
		link.add("沈晓毅");
		link.add("郑海彬");
		link.add("黄志翔");
		System.out.println("初始Linked集合："+link.toString());
		link.add(2, "陈喆");
		System.out.println("加人后Linked集合："+link);
		link.remove(3);
		System.out.println("删人后Linked集合："+link);
	}
}
