package Ex0310;

/*
 *��̬�ı��� 
 */
class Per08 {
	static String shoolName;// ���徲̬����shollName
}

public class Ex08 {
	public static void main(String[] args) {
		Per08 stu1 = new Per08();// ����ѧ������
		Per08 stu2 = new Per08();
		// ��̬��Ա�ĵ��÷���������.����
		Per08.shoolName = "������";
		System.out.println("�ҵ�ѧУ�ǣ�" + stu1.shoolName);// ��ӡ��һ��ѧ�������ѧУ��
		System.out.println("�ҵ�ѧУ�ǣ�" + stu2.shoolName);// ��ӡ�ڶ���ѧ�������ѧУ��
	}
}
