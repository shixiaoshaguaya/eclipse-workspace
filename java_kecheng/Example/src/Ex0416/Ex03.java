package Ex0416;

import java.io.*;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		OutputStream out = new FileOutputStream("example.txt", true);
		String str = "欢迎你";
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
	}
}
