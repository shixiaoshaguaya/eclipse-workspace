package cz0409;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class List_Ex {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("֣����");
		list.add("������");
		list.add("��־��");
		list.add("������");
		System.out.println("ArrayList���ϣ�" + list);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		System.out.println("���ϵĳ��ȣ�" + list.size());
		System.out.println("��3��Ԫ���ǣ�" + list.get(2));
		LinkedList link = new LinkedList();
		link.add("������");
		link.add("������");
		link.add("֣����");
		link.add("��־��");
		System.out.println("��ʼLinked���ϣ�" + link.toString());
		for(Object str: link) {
			System.out.println(str);
		}
		link.add(2, "��");
		System.out.println("���˺�Linked���ϣ�" + link);
		link.remove(3);
		System.out.println("ɾ�˺�Linked���ϣ�" + link);
	}
}
