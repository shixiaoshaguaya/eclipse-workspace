package cz0421;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		System.out.println("FileWriter对象用于向文件中写入数据");
		FileWriter writer = new FileWriter("cz0421.txt");
		String str = "chenzhe";
		writer.write(str);
		writer.write("\r\n");
		writer.close();
		System.out.println("创建一个FileReader对象用来读取文件中的字符");
		FileReader reader = new FileReader("cz0421.txt");
		int ch;
		while ((ch = reader.read()) != -1) {
			System.out.print((char) ch);
		}
		reader.close();
		System.out.println("利用BufferedReader和BufferedWriter来实现文件拷贝");
		FileReader reader1 = new FileReader("cz0421.txt");
		BufferedReader br = new BufferedReader(reader1);
		FileWriter writer1 = new FileWriter("cz0421_copy.txt");
		BufferedWriter bw = new BufferedWriter(writer1);
		String str1;
		while ((str1 = br.readLine()) != null) {
			bw.write(str1);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
