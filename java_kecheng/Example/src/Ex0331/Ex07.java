package Ex0331;

/*
 * String����쳣��ʾ
 * 	String�ַ����ڻ�ȡĳ���ַ�ʱ�����õ��ַ����������������ַ����е��ַ�ʱ��
 * 	����ַ������������ڣ���ᷢ��StringIndeOutOfBoundsException���ַ����Ǳ�Խ���쳣��
 */
public class Ex07 {
	public static void main(String[] args) {
		//����һ���ַ���
		String s = "abcdedcba";
		System.out.println(s.charAt(10));
	}
}
