package Ex0331;

/*
 * String��Ļ�������
 * 	�ڳ����У���Ҫ�ַ�������һЩ�����������������ַ������ȡ����ָ��λ�õ��ַ���
 * 	public int length������ȡ�ַ����ĳ���
 * 	public char charAt��int index����ȡ�ַ�����ָ��λ���ϵ��ַ�
 * 	public int indexOf��char ch����ȡָ���ַ����ַ����е�һ�γ��ֵ�λ��
 * 	public int lastIndexOf��char ch����ȡָ���ַ����ַ��������һ�γ��ֵ�λ��
 * 	public int indexOf��Sting str����ȡָ���Ӵ����ַ����е�һ�γ��ֵ�λ��
 * 	public int lastIndexOf��String str����ȡָ���Ӵ����ַ��������һ�γ��ֵ�λ��
*/
public class Ex02 {
	public static void main(String[] args) {
		String s = "ababcdedcba";// �����ַ���
		System.out.println("�ַ����ĳ���Ϊ��" + s.length());// ��ȡ�ַ������ȣ����ַ�����
		System.out.println("�ַ����е�һ���ַ���" + s.charAt(0));
		System.out.println("�ַ�c��һ�γ��ֵ�λ�ã�" + s.indexOf('c'));
		System.out.println("�ַ�c���һ�γ��ֵ�λ�ã�" + s.lastIndexOf('c'));
		System.out.println("���ַ�����һ�γ��ֵ�λ�ã�" + s.indexOf("ab"));
		System.out.println("���ַ������һ�γ��ֵ�λ�ã�" + s.lastIndexOf("ab"));
	}
}
