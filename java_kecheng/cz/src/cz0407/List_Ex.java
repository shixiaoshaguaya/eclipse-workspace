package cz0407;

import java.util.ArrayList;
import java.util.LinkedList;

public class List_Ex {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("֣����");
		list.add("������");
		list.add("��־��");
		list.add("������");
		System.out.println("ArrayList���ϣ�"+list);
		System.out.println("���ϵĳ��ȣ�"+ list.size());
		System.out.println("��3��Ԫ���ǣ�"+ list.get(2));
		LinkedList link = new LinkedList();
		link.add("������");
		link.add("������");
		link.add("֣����");
		link.add("��־��");
		System.out.println("��ʼLinked���ϣ�"+link.toString());
		link.add(2, "��");
		System.out.println("���˺�Linked���ϣ�"+link);
		link.remove(3);
		System.out.println("ɾ�˺�Linked���ϣ�"+link);
	}
}
