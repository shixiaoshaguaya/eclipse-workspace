package Ex0326;

public class Ex08 {
	public static void main(String[] args) {
		// ����divide��������������һ��������Ϊ������
		int result = divide(4, -2);
		System.out.println(result);
	}

	// ����ķ���ʵ���������������
	public static int divide(int x, int y) {
		if (y < 0) {
			// ʹ��throw�ؼ��������쳣����
			//throw new Ex07("�����Ǹ���");
		}
		int result = x / y;// ����һ������result��¼����������Ľ��
		return result;// ���������
	}
}
