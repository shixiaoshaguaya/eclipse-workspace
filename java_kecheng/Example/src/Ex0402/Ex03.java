package Ex0402;

/*
 * arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
 * 	arraycopy()�������ڽ�һ��������Ԫ�ؿ��ٿ�������һ�����飬���еĲ��������������£�
 * 	src����ʾԴ���顣
 * 	dest����ʾĿ�����顣
 * 	srcPos����ʾԴ�����п���Ԫ�ص���ʼλ�á�
 * 	destPos����ʾĿ�������е���ʼλ�á�
 * 	length����ʾ����Ԫ�صĸ����� 
 */
public class Ex03 {
	public static void main(String[] args) {
		int[] fromArray = { 101, 102, 103, 104, 105, 106 };// Դ����
		int[] toArray = { 201, 202, 203, 204, 205, 206, 207 };// Ŀ������
		// ��������Ԫ�أ���fromArray����2�Ǳ�λ�ÿ�ʼ������4��Ԫ�أ���toArray����3�Ǳ�λ��
		System.arraycopy(fromArray, 2, toArray, 3, 4);
		// ��ӡtoArray�����е�Ԫ��
		for (int i = 0; i < toArray.length; i++) {
			System.out.println(i + ":" + toArray[i]);
		}
	}
}
