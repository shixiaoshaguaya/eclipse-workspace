package Ex0407;

import java.util.ArrayList;

public class Ex01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();// ����ArrayList����
		list.add("stu1");// �򼯺������Ԫ��
		list.add("stu2");
		list.add("stu3");
		list.add("stu4");
		System.out.println("���ϵĳ��ȣ�"+ list.size());
		System.out.println("��2��Ԫ���ǣ�"+ list.get(1));
	}
}
