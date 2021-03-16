package cz0416;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("cz.txt");
		String str = "chenzhe";
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
		FileInputStream in = new FileInputStream("cz.txt");
		int a = 0;
		while (true) {
			a = in.read();
			if (a == -1) {
				break;
			}
			System.out.println(a);
		}
		in.close();
	}
}
