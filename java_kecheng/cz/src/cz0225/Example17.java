package cz0225;

/*
 * break��䣨�������ѭ����
 */
public class Example17 {
	public static void main(String[] args) {
		int i, j;// ��������ѭ������
		itcast: for (i = 1; i <= 9; i++) {// ���ѭ��
			for (j = 1; j <= i; j++) {// �ڲ�ѭ��
				if (i > 4) {
					break itcast;
				}
				System.out.print("*");// ��ӡ
			}
			System.out.print("\n");// ����
		}
	}
}
