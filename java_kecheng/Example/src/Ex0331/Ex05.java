package Ex0331;

/*
 * String����жϲ���
 * 	�����ַ���ʱ��������Ҫ���ַ�������һЩ�жϣ����ж��ַ������Ƿ���ָ�����ַ�����ʼ���������Ƿ����ָ�����ַ������ַ����Ƿ�Ϊ�յ�
 * 	public boolean startsWith��String str���ж��ַ����Ƿ����ַ���Str��ͷ
 * 	public boolean endsWith��String str���ж��Ƿ����ַ���ng��β
 * 	public boolean contains��String str���ж��Ƿ�����ַ���tri
 * 	public boolean isEmpty�����ж��ַ����Ƿ�Ϊ��
 * 	public boolean equals��String str���ж������ַ����Ƿ����
 */
public class Ex05 {
	public static void main(String[] args) {
		String s1 = "String";// ����һ���ַ���
		String s2 = "Str";
		System.out.println("�ж��Ƿ����ַ���Str��ͷ��" + s1.startsWith("Str"));
		System.out.println("�ж��Ƿ����ַ���ng��β��" + s1.endsWith("ng"));
		System.out.println("�ж��Ƿ�����ַ���tri��" + s1.contains("tri"));
		System.out.println("�ж��ַ����Ƿ�Ϊ�գ�" + s1.isEmpty());
		System.out.println("�ж������ַ����Ƿ���ȣ�" + s2.equals(s2));
	}
}
