package Ex0402;

/*
 * Runtime�����ṩһ��exec�����������÷�������z'xһ��dos����Ӷ�ʵ�ֺ������������dos����ͬ����Ч��
 */
import java.io.IOException;

public class Ex05 {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();// ����Runtimeʵ������
		rt.exec("notepad.exe");// ����exec��������
	}
}
