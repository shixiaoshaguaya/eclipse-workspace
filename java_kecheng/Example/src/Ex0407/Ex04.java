package Ex0407;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); // ����ArrayList����
		list.add("Jack"); // �򼯺�������ַ���Ԫ��
		list.add("Rose");
		list.add("Tom");
		for (Object obj : list) {// ʹ��foreachѭ����������
			System.out.println(obj);// ȡ������ӡ�����е�Ԫ��
		}
	}
}
