package Ex0310;

/*
 * ��������
 */
class Per07 {
	// ���涨���finalize�������ڶ�������������֮ǰ����
	public void finalize() {
		System.out.println("������Ϊ��������...");
	}
}

public class Ex07 {
	public static void main(String[] args) throws Exception {
		// �����Ǵ���������Per07����
		Per07 p1 = new Per07();
		Per07 p2 = new Per07();
		// ���潫������Ϊnull���ö����Ϊ����
		p1 = null;
		p2 = null;
		// ���÷���������������
		System.gc();
		Thread.sleep(5000);
	}
}
