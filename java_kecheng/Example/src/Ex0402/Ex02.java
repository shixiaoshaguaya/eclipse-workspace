package Ex0402;

/*
 * public static long currentTimMillis����
 * 	��������һ��long���͵�ֵ����ֵ��ʾ��ǰʱ����1970��1��1��0��0��0��֮���ʱ����λ�Ǻ��룬ͨ��Ҳ����ֵ��ʱ����
 */
public class Ex02 {
	public static void main(String[] args) {
		// ��������ڽ�����Ͳ���ʱ�����ĵ�ʱ��
		long startTime = System.currentTimeMillis();// ѭ����ʼʱ�ĵ�ǰʱ��
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long endTime = System.currentTimeMillis();// ѭ�������ĵ�ǰʱ��
		System.out.println("�������е�ʱ��Ϊ��" + (endTime - startTime) + "����");
	}
}
