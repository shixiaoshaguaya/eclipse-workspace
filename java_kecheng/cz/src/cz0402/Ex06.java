package cz0402;

import java.util.Arrays;

public class Ex06 {
	private static final String SPACE_SEPARATOR=" ";
	public static void main(String[] args) {
		String numStr = "21 45 78 -2 11 49";
		System.out.println(numStr);
		numStr = sortStringNumber(numStr);
		System.out.println(numStr.toString());
	}
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
	public static String arrayToString(int[] num_arr) {
		StringBuffer sb = new StringBuffer();
		for(int x = 0;x<num_arr.length;x++) {
			if(x!=num_arr.length-1) {
				sb.append(num_arr[x]+SPACE_SEPARATOR);
			}else {
				sb.append(num_arr[x]);
			}
		}
		return sb.toString();
	}
	public static void mySorArray(int[] num_arr){
		Arrays.sort(num_arr);
	}
	public static int[] toIntArray(String[] str_arr) {
		int[] arr = new int[str_arr.length];
		for(int i=0;i<arr.length;i++) {
			arr[i]= Integer.parseInt(str_arr[i]);
		}
		return arr;
	}
	public static String[] stringToArray(String numStr) {
		String[] str_arr = numStr.split(SPACE_SEPARATOR);
		return str_arr;
	}
}
