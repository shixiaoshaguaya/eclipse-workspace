package Ex0326;

public class Ex04 {
	public static void main(String[] args) {
		//int result = divide(4, 0);// ����divide��������
		//System.out.println(result);
	}

	// ����ķ���ʵ���������������,��ʹ��throw�ؼ��������׳��쳣
	public static int divide(int x, int y) throws Exception {
		int result = x / y;// ����һ������result��¼����������Ľ��
		return result;// ���������
	}
}
