package Ex0402;

/*
 * ���䣺����ָ�������������͵Ķ���תΪ������������
 * 
 * Integer��ķ���
 * 	public int intValue������int���ͷ��ظ�Integer��ֵ
 */
public class Ex12 {
	public static void main(String[] args) {
		Integer num = new Integer(20);
		int a = 10;
		int sum = num.intValue() + a;
		System.out.println("sum=" + sum);
	}
}
