package Ex0331;

/*
 * String����滻��ȥ���ո����
 * 	���򿪷��У��û���������ʱ��������һЩ����Ϳո���ʱ����ʹ��String���replace������trim���������������ַ������滻��ȥ���ո����
 * 	public String replace��String oldStr�� String newStr��
 * 		��ԭ���ַ�����oldStr�ַ���������newStr�ַ��������������һ���µ��ַ���
 * 	public String trim��������һ�����ַ�������ȥ����ԭ���ַ��������˿ո�
 */
public class Ex04 {
	public static void main(String[] args) {
		String s = "itcast";
		// �ַ����滻����
		System.out.println("��it�滻��cn.it�Ľ��" + s.replace("it", "cn.it"));
		// �ַ���ȥ���ո����
		String s1 = "   i t c a s t   ";
		System.out.println("ȥ���ַ������˿ո��Ľ����" + s1.trim());
		System.out.println("ȥ���ַ��������пո�Ľ����" + s1.replace(" ", ""));
	}
}
