package cz0402;

public class Ex05 {
	public static void main(String[] args) {
		int w=Integer.parseInt("30");
		int h=Integer.parseInt("15");
		for (int i = 0; i < h; i++) {
			StringBuffer sb=new StringBuffer();
			for (int j = 0; j < w; j++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
	}
}
