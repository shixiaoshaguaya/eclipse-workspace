package Ex0331;

/*
 * String��Ľ�ȡ��ָ����
 * 	��String��������ַ����Ľ�ȡ�ͷָ�����ṩ������������
 * 	���У�substring�����������ڽ�ȡ�ַ�����һ����
 * 	split�����������Խ��ַ�������ĳ���ַ����зָ�
 * 	
 * 	public String substring��int start������һ�����ַ�����ָ��λ�ÿ�ʼ��ȡ�����ַ���ĩβ����
 * 	public String substring��int start�� int end������һ�����ַ���������ԭ���ַ���ָ��λ�ÿ�ʼ��ȡ����ָ��λ�ý���
 * 	public String[] split��String regex������ָ�����ַ������зָ��һ���ַ�������
 */
public class Ex06 {
	public static void main(String[] args) {
		String str = "��ë��-����-ƹ����";
		// �������ַ�����ȡ����
		System.out.println("�ӵ�5���ַ���ȡ��ĩβ�Ľ����" + str.substring(4));
		System.out.println("�ӵ�5���ַ���ȡ����6���ַ��Ľ����" + str.substring(4, 6));// ��������βλ�õ��ַ�
		// �������ַ����ָ����
		System.out.println("�ָ����ַ��������е�Ԫ������Ϊ��");
		String[] strArray = str.split("-");// ���ַ���ת��Ϊ�ַ�������
		for (int i = 0; i < strArray.length; i++) {
			if (i != strArray.length - 1) {
				// ���������������һ��Ԫ�أ���Ԫ�غ���Ӷ���
				System.out.print(strArray[i] + ",");
			} else {
				// ��������һ��Ԫ�غ��治�Ӷ���
				System.out.println(strArray[i]);
			}
		}
	}
}
