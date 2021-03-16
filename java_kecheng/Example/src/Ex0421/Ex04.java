package Ex0421;
import java.io.*;

public class Ex04 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("src.txt");//创建字节输入流
		// 将字节流输入转换成字符输入流
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);//赋予字符流对象缓冲区
		FileOutputStream out = new FileOutputStream("des_04.txt");
		//将字节输出流转换成字符输出流
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);//赋予字符输出流对象缓冲区
		String line;
		while ((line= br.readLine())!=null) {//判断释放读到文件末尾
			bw.write(line);//输出读取到的文件
		}
		br.close();
		bw.close();
	}
}
