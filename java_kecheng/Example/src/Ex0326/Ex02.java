package Ex0326;

public class Ex02 {
	public static void main(String[] args) {
		// ����Ĵ��붨����һ��try...catch������ڲ����쳣
		try {
			int result = divide(4, 2);// ����divide��������
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("������쳣��ϢΪ��" + e.getMessage());
		}
		System.out.println("�����������ִ��...");
	}

	// ����ķ���ʵ���������������
	public static int divide(int x, int y) {
		int result = x / y;// ����һ������result��¼liang'g ������Ľ��
		return result;// ���������
	}
}
