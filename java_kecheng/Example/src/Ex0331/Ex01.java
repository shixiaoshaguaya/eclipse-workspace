package Ex0331;

/*
 * String��ĳ�ʼ������
 * 	1.�ַ�������ֱ�Ӹ�ֵ
 * 	2.String��Ĺ��췽��
 * 		String�����ղ������췽��������һ��String���������Ϊ��
 * 		String��String s������һ��String�����ָ��һ���ַ�������
 * 		String��Char[] chs������һ��String�����ָ��һ���ַ�������Ϊ����
 */
public class Ex01 {
	public static void main(String[] args) throws Exception {
		// �ַ�������ֱ�Ӹ�ֵ
		String str1 = "abc";
		// String��String s������һ��String�����ָ��һ���ַ�������
		String str2 = new String();
		// String��String s������һ��String�����ָ��һ���ַ�������
		String str3 = new String("abcd");
		// String��String s������һ��String�����ָ��һ���ַ�������
		char[] charArray = new char[] { 'E', 'F', 'G' };
		String str4 = new String(charArray);
		System.out.println(str1);
		System.out.println("a" + str2 + "b");
		System.out.println(str3);
		System.out.println(str4);
	}
}