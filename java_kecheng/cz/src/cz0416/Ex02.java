package cz0416;

import java.io.*;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		InputStream in1 = new FileInputStream("source\\�ַ���.mp4");
		OutputStream out1 = new FileOutputStream("target\\�ַ���.mp4");
		byte[] buff = new byte[1024];
		int len1;
		long begintime1 = System.currentTimeMillis();
		while ((len1 = in1.read(buff)) != -1) {
			out1.write(buff, 0, len1);
		}
		long endtime1 = System.currentTimeMillis();
		System.out.println("�����ֽڻ����������ļ������ĵ�ʱ���ǣ�" + (endtime1 - begintime1) + "����");
		in1.close();
		out1.close();
		InputStream in = new FileInputStream("source\\�ַ���.mp4");
		OutputStream out = new FileOutputStream("target\\�ַ���1.mp4");
		int len;
		long begintime = System.currentTimeMillis();
		while ((len = in.read()) != -1) {
			out.write(len);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("��ͨ�ֽ��������ļ������ĵ�ʱ���ǣ�" + (endtime - begintime) + "����");
		in.close();
		out.close();
	}
}
