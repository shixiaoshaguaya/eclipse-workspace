package Ex0421;
import java.io.*;

public class Ex04 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("src.txt");//�����ֽ�������
		// ���ֽ�������ת�����ַ�������
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);//�����ַ������󻺳���
		FileOutputStream out = new FileOutputStream("des_04.txt");
		//���ֽ������ת�����ַ������
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);//�����ַ���������󻺳���
		String line;
		while ((line= br.readLine())!=null) {//�ж��ͷŶ����ļ�ĩβ
			bw.write(line);//�����ȡ�����ļ�
		}
		br.close();
		bw.close();
	}
}
