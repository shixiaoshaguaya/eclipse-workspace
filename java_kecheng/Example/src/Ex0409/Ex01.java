package Ex0409;

import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
		HashSet set = new HashSet();// ����HashSet����
		set.add("Jack");// ���Set����������ַ���
		set.add("Eve");
		set.add("Rose");
		set.add("Rose");// ���Set����������ظ�Ԫ��
		Iterator it = set.iterator();// ��ȡIterator����
		while (it.hasNext()) {// ͨ��whileѭ�����жϼ������Ƿ���Ԫ��
			Object obj = it.next();
			System.out.println(obj);
		}
	}
}
