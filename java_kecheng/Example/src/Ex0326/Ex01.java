package Ex0326;

public class Ex01 {
	public static void main(String[] args) {
		int result = divide(4, 0);// ����divide��������
		System.out.println(result);
	}

	// ����ķ���ʵ���������������
	public static int divide(int x, int y) {
		int result = x / y;// ����һ������result��¼liang'g ������Ľ��
		return result;// ���������
	}
}
