package Ex0402;

/*
 * Math���бȽϳ����ķ���
 * 	public static int abs��int a�����ز����ľ���ֵ
 * 	public static double ceil��double a�����ش��ڲ�������С����
 * 	public static double floor��double a)����С�ڲ������������
 * 	public static long round��dounle a����������
 * 	public static float max��float a, float b�������������Ľϴ�ֵ
 * 	public static double min��double a, double b�������������Ľ�Сֵ
 * 	public static double random��������һ�����ڵ���0.0С��1.0���С��
 */
public class Ex07 {
	public static void main(String[] args) {
		System.out.println("�������ֵ�Ľ����" + Math.abs(-1));
		System.out.println("����ڲ�������С������" + Math.ceil(5.6));
		System.out.println("��С�ڲ��������������" + Math.floor(-4.2));
		System.out.println("��С���������������Ľ����" + Math.round(-4.6));
		System.out.println("���������Ľϴ�ֵ��" + Math.max(2.1, -2.1));
		System.out.println("���������Ľ�Сֵ��" + Math.min(2.1, -2.1));
		System.out.println("����һ�����ڵ���0.0С��1.0���ֵ��" + Math.random());
	}
}
