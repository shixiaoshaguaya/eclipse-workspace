package Ex0326;

public class Ex09 {
	public static void main(String[] args) {
		// ����Ĵ��붨����һ��try...catch������ڲ����쳣
		try {
			// ����divide��������������һ��������Ϊ������
			int result = divide(4, -2);
			System.out.println(result);
		} catch (Exception e) {// �Բ��񵽵��쳣���д���
			System.out.println(e.getMessage());// ��ӡ������쳣��Ϣ
		}
	}

	// ����ķ���ʵ�������������������ʹ��throws�ؼ��������׳��Զ����쳣
	public static int divide(int x, int y) throws Ex07{
		if (y < 0) {
			// ʹ��throw�ؼ��������쳣����
			throw new Ex07("�����Ǹ���");
		}
		int result = x / y;// ����һ������result��¼����������Ľ��
		return result;// ���������
	}
}
