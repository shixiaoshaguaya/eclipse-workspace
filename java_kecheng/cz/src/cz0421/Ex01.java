package cz0421;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		System.out.println("FileWriter�����������ļ���д������");
		FileWriter writer = new FileWriter("cz0421.txt");
		String str = "chenzhe";
		writer.write(str);
		writer.write("\r\n");
		writer.close();
		System.out.println("����һ��FileReader����������ȡ�ļ��е��ַ�");
		FileReader reader = new FileReader("cz0421.txt");
		int ch;
		while ((ch = reader.read()) != -1) {
			System.out.print((char) ch);
		}
		reader.close();
		System.out.println("����BufferedReader��BufferedWriter��ʵ���ļ�����");
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
