package Ex0331;

/*
 * String���ת������
 * 	���򿪷��У�������Ҫ���ַ������в��������罫�ַ���ת�����������ʽ�����ַ����е��ַ����д�Сдת����
 * 	public char[] toCharArry���������ַ���ת�����ַ�����
 * 	public static String valueOf��int n����ָ��intֵת����String����
 *  public String toUpperCase���������ַ����е��ַ�ȫ��ת���ɴ�д��ĸ���᷵��һ���µ��ַ���
 */
public class Ex03 {
	public static void main(String[] args) {
		// ����һ���ַ���
		String str = "abcd";
		// �����ַ���ת�����ַ�����
		System.out.print("���ַ���ת��Ϊ�ַ������Ľ����");
		char[] charArray = str.toCharArray();// �ַ���ת��Ϊ�ַ�����
		for (int i = 0; i < charArray.length; i++) {
			if (i != charArray.length - 1) {
				// ���������������һ��Ԫ�أ���Ԫ�غ���Ӷ���
				System.out.print(charArray[i] + ",");
			} else {
				// ��������һ��Ԫ�غ󲻼Ӷ���
				System.out.println(charArray[i]);
			}
		}
		System.out.println("��intֵת��ΪString����֮��Ľ����" + String.valueOf(12));
		System.out.println("���ַ���ת���ɴ�д֮��Ľ����" + str.toUpperCase());
	}
}
