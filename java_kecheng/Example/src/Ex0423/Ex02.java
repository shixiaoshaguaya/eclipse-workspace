package Ex0423;

import java.io.File;

public class Ex02 {
	public static void main(String[] args) {
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example");
		if (file.isDirectory()) {// �ж�File�����Ӧ��Ŀ¼�Ƿ����
			String[] names = file.list();// ��ȡĿ¼�µ������ļ����ļ���
			for (String name : names) {
				System.out.println(name);// ����ļ���
			}
		}
	}

}
