package Ex0407;

import java.util.*;

public class Ex06 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();// ����ArrayList����
		list.add("Jack");
		list.add("Annie");
		list.add("Rose");
		list.add("Tom");
		Iterator it = list.iterator(); // ���Iterator����
		while (it.hasNext()) {// �жϸü����Ƿ�����һ��Ԫ��
			Object obj = it.next();// ��ȡ�ü����е�Ԫ��
			if ("Annie".equals(obj)) {// �жϸü�����Ԫ���Ƿ�ΪAnnie
				list.remove(obj);// ɾ���ü����е�Ԫ��
				break;
			}
		}
		System.out.println(list);
	}
}
