package Ex0324;

/*
 * ���������
 */
public class Task02Test {
	public static void main(String[] args) {
		// ������������
		SendTask task = new SendTask("HYX600235", 76.34);
		// ������ǰ׼������
		task.sendBefore();
		System.out.println("====================");
		// ������ͨ���߶���
		Ztransportation t = new Ztransportation("Z0265", "��", "С��");
		// ����GPS���߶���
		Phone p = new Phone();
		// ����ͨ������GPS���ߴ����ͻ�����
		task.send(t, p);
		System.out.println("====================");
		// �����ͺ��������
		task.sendAfter(t);
		t.upKeep();
	}
}
