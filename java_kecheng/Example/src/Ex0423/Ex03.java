package Ex0423;

import java.io.File;
import java.io.FilenameFilter;

public class Ex03 {
	public static void main(String[] args) {
		// ����File����
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example");
		// ��������������
		FilenameFilter filter = new FilenameFilter() {
			// ʵ��accept��������
			public boolean accept(File dir, String name) {
				File currFile = new File(dir, name);
				// ����ļ�����.txt��β����true�����򷵻�false
				if (currFile.isFile() && name.endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		};
		if (file.exists()) {// �ж�File�����Ӧ��Ŀ¼�Ƿ����
			String[] lists = file.list(filter);// ��ȡ���˺�������ļ�������
			for (String name : lists) {
				System.out.println(name);
			}
		}
	}
}
