package Ex0423;

import java.io.File;

public class Ex05 {
	public static void main(String[] args) {
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example\\test\\cz0421");// ����һ������Ŀ¼��File����
		if (file.exists()) {
			System.out.println(file.delete());
		}
	}
}
