package Ex0402;

import java.util.Arrays;

/*
 * �ַ����������
 */
public class WrapperTest {
	private static final String SPACE_SEPARATOR = " ";

	public static void main(String[] args) {
		String numStr = "20 78 9 -7 88 36 29";
		System.out.println(numStr);
		// ���÷�����ʵ�ֵõ�һ����С������ַ���
		numStr = sortStringNumber(numStr);
		System.out.println(numStr.toString());
	}

	// ����һ����С������ַ���"-7 9 20 29 36 78 88"
	private static String sortStringNumber(String numStr) {
		// 1,���ַ�������ַ�����
		String[] str_arr = stringToArray(numStr);
		// 2,���ַ���������int����
		int[] num_arr = toIntArray(str_arr);
		// 3,��int��������
		mySorArray(num_arr);
		// 4,��������int�������ַ���
		String trmp = arrayToString(num_arr);
		return trmp;
	}

	// ��int����ת����String
	public static String arrayToString(int[] num_arr) {
		StringBuffer sb = new StringBuffer();
		// ͨ��ѭ�����õ�ÿһ��intԪ��
		for (int x = 0; x < num_arr.length; x++) {
			// �жϵ�ǰԪ�أ��Ƿ�Ϊ�������һ��Ԫ��
			if (x != num_arr.length - 1) {
				sb.append(num_arr[x] + SPACE_SEPARATOR);
			} else {
				sb.append(num_arr[x]);
			}
		}
		return sb.toString();
	}

	public static void mySorArray(int[] num_arr) {
		Arrays.sort(num_arr);
	}

	// ��String����ת����Ϊint����
	public static int[] toIntArray(String[] str_arr) {
		// ����int����
		int[] arr = new int[str_arr.length];
		// ��String����Ԫ��ת����intԪ�أ��洢��int������
		for (int i = 0; i < arr.length; i++) {
			// �õ�ÿһ���ַ���str_arr[i]
			// ���ַ�������ת����int����Integer.parseInt��String str��
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		return arr;
	}

	public static String[] stringToArray(String numStr) {
		String[] str_arr = numStr.split(SPACE_SEPARATOR);
		return str_arr;
	}
}
