package cz0421;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Notepad {
	private static String filePath;
	private static String message = "";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("--1���½��ļ�   2�����ļ�  3���޸��ļ�  4������  5���˳�--");
		while (true) {
			System.out.print("���������ָ�");
			int command = sc.nextInt();
			switch (command) {
			case 1:
				createFile();
				break;
			case 2:
				openFile();
				break;
			case 3:
				editFile();
				break;
			case 4:
				saveFile();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("�������ָ�����");
				break;
			}
		}
	}

	/**
	 * �½��ļ� �ӿ���̨��ȡ����
	 */
	private static void createFile() {
		message = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("���������ݣ�ֹͣ��д������\"stop\"��");
		StringBuffer stb = new StringBuffer();
		String inputMessage = "";
		while (!inputMessage.equals("stop")) {
			if (stb.length() > 0) {
				stb.append("\r\n");
			}
			stb.append(inputMessage);
			inputMessage = sc.nextLine();
		}
		message = stb.toString();
	}

	/**
	 * ���ļ�
	 */
	private static void openFile() throws Exception {
		message = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ļ���λ�ã�");
		filePath = sc.next();
		if (filePath != null && !filePath.endsWith(".txt")) {
			System.out.println("��ѡ���ı��ļ���");
			return;
		}
		FileReader in = new FileReader(filePath);
		char[] charArray = new char[1024];
		int len = 0;
		StringBuffer sb = new StringBuffer();
		while ((len = in.read(charArray)) != -1) {
			sb.append(charArray);
		}
		message = sb.toString();
		System.out.println("���ļ����ݣ�" + "\r\n" + message);
		in.close();
	}

	/**
	 * �޸��ļ����� ͨ���ַ����滻����ʽ
	 */
	private static void editFile() {
		if (message == "" && filePath == null) {
			System.out.println("�����½��ļ����ߴ��ļ�");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ����ݣ���\"�޸ĵ�Ŀ�����֣��޸�֮�������\"��ʽ����" + "ֹͣ�޸�������\"stop\":");
		String inputMessage = "";
		while (!inputMessage.equals("stop")) {
			inputMessage = sc.nextLine();
			if (inputMessage != null && inputMessage.length() > 0) {
				String[] editMessage = inputMessage.split(":");
				if (editMessage != null && editMessage.length > 1) {
					message = message.replace(editMessage[0], editMessage[1]);
				}
			}
		}
		System.out.println("�޸ĺ�����ݣ�" + "\r\n" + message);
	}

	/**
	 * ���� �½��ļ������û������·�� �򿪵��ļ���ԭ�ļ�����
	 */
	private static void saveFile() throws IOException {
		Scanner sc = new Scanner(System.in);
		FileWriter out = null;
		if (filePath != null) {
			out = new FileWriter(filePath);
		} else {
			System.err.println("�������ļ�����ľ���·����");
			String path = sc.next();
			filePath = path;
			if (!filePath.toLowerCase().endsWith(".txt")) {
				filePath += ".txt";
			}
			out = new FileWriter(filePath);
		}
		out.write(message);
		out.close();
		message = "";
		filePath = null;
	}

	/**
	 * �˳�
	 */
	private static void exit() {
		System.out.println("�����˳�ϵͳ��ллʹ�ã�");
		System.exit(0);
	}
}
