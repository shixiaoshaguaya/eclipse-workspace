package cz0225;

/*
 * if..else if...else����ʹ��
 */
public class Example09 {
	public static void main(String[] args) {
		int grade = 75; // ����ѧ���ɼ�
		if (grade > 80) {
			// ��������>80
			System.out.println("�óɼ��ĵȼ�Ϊ��");
		} else if (grade > 70) {
			// ������>80,��������>70
			System.out.println("�óɼ��ĵȼ�Ϊ��");
		} else if (grade > 60) {
			// ������>70,��������>60
			System.out.println("�óɼ��ĵȼ�Ϊ��");
		} else {
			System.out.println("�óɼ��ĵȼ�Ϊ��");
		}
	}
}
