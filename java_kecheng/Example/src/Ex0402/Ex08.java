package Ex0402;

import java.util.Random;

/*
 * ʹ�ù��췽��Random�������������
 * 	public int nextInt��int n��0~n֮����������������0��������n
 */
public class Ex08 {
	public static void main(String[] args) {
		Random r = new Random();// ����������
		// �������10��[0,100)֮�������
		for (int x = 0; x < 10; x++) {
			System.out.println(r.nextInt(100));
		}
	}
}
