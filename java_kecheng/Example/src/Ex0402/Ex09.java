package Ex0402;

import java.util.Random;

/*
 * ʹ�ù��췽��Random��long seed�����������
 */
public class Ex09 {
	public static void main(String[] args) {
		Random r = new Random(13);// ��������ʱ��������
		// �������10��[0,100)֮�������
		for (int x = 0; x < 10; x++) {
			System.out.println(r.nextInt(100));
		}
	}
}
