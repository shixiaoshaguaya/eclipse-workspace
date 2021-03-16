package cz0416;

import java.io.*;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		InputStream in1 = new FileInputStream("source\\字符流.mp4");
		OutputStream out1 = new FileOutputStream("target\\字符流.mp4");
		byte[] buff = new byte[1024];
		int len1;
		long begintime1 = System.currentTimeMillis();
		while ((len1 = in1.read(buff)) != -1) {
			out1.write(buff, 0, len1);
		}
		long endtime1 = System.currentTimeMillis();
		System.out.println("利用字节缓冲流拷贝文件所消耗的时间是：" + (endtime1 - begintime1) + "毫秒");
		in1.close();
		out1.close();
		InputStream in = new FileInputStream("source\\字符流.mp4");
		OutputStream out = new FileOutputStream("target\\字符流1.mp4");
		int len;
		long begintime = System.currentTimeMillis();
		while ((len = in.read()) != -1) {
			out.write(len);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("普通字节流拷贝文件所消耗的时间是：" + (endtime - begintime) + "毫秒");
		in.close();
		out.close();
	}
}
