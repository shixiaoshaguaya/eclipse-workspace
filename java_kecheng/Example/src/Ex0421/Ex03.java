package Ex0421;
import java.io.*;
public class Ex03 {
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("src.txt");
		// ����һ��BufferedReader�������
		BufferedReader br = new BufferedReader(reader);
		FileWriter writer =new FileWriter("des.txt");
		// ����һ��BufferdWriter����������
		BufferedWriter bw = new BufferedWriter(writer);
		String str;
		while ((str= br.readLine())!=null) {
			bw.write(str);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
