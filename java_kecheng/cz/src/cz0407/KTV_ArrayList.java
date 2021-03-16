package cz0407;

import java.util.ArrayList;
import java.util.Scanner;

public class KTV_ArrayList {
	public static void main(String[] args) {
		System.out.println("----------��ӭ�������ϵͳ---------------");
		System.out.println("0.��Ӹ������б�");
		System.out.println("1.�������ö�");
		System.out.println("2.������ǰ��һλ");
		System.out.println("3.�˳�");
		ArrayList lineUpList = new ArrayList();// ���������б�
		addMusicList(lineUpList);// ���һ���ָ����������б�
		while (true) {
			System.out.print("����Ҫִ�еĲ�������ţ�");
			java.util.Scanner scan = new Scanner(System.in);
			int command = scan.nextInt();// ���ռ�������Ĺ���ѡ�����
			// ִ����Ŷ�Ӧ�Ĺ���
			switch (command) {
			case 0:// ��Ӹ������б�
				addMusic(lineUpList);
				break;
			case 1:// �������ö�
				setTop(lineUpList);
				break;
			case 2:// ������ǰ��һλ
				setBefore(lineUpList);
				break;
			case 3:// �˳�
				exit();
				break;
			default:
				System.out.println("------------------------------");
				System.out.println("����ѡ��������������ȷ�Ĺ�����ţ�");
				break;
			}
			System.out.println("��ǰ�����б�" + lineUpList);
		}
	}

	// ��ʼʱ��Ӹ�������
	private static void addMusicList(ArrayList lineUpList) {
		lineUpList.add("Сƻ��");
		lineUpList.add("�ҵĿ��־�������");
		lineUpList.add("������Ը������");
		lineUpList.add("����˼");
		lineUpList.add("���ڷ�");
		System.out.println("��ʼ�����б�" + lineUpList);
	}

	// ִ����Ӹ���
	private static void addMusic(ArrayList lineUpList) {
		System.out.print("������Ҫ��ӵĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		lineUpList.add(musicName);// ��Ӹ������б�����
		System.out.println("����Ӹ�����" + musicName);
	}

	// ִ�н������ö�
	private static void setTop(ArrayList lineUpList) {
		System.out.print("������Ҫ�ö��ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		int postion = lineUpList.indexOf(musicName);// ����ָ������λ��
		if (postion < 0) {// �ж���������Ƿ����
			System.out.println("��ǰ�б���û������ĸ�����");
		} else {
			lineUpList.remove(musicName);// �Ƴ�ָ���ĸ���
			lineUpList.add(0, musicName);// ��ָ���ĸ����ŵ���һλ
		}
		System.out.println("�ѽ�����" + musicName + "�ö�");
	}

	// ִ�н�������ǰһλ
	private static void setBefore(ArrayList lineUpList) {
		System.out.print("������Ҫ��ǰ�ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		int postion = lineUpList.indexOf(musicName);// ����ָ������λ��
		if (postion < 0) {// �ж���������Ƿ����
			System.out.println("��ǰ�б���û������ĸ�����");
		} else if (postion == 0) {
			System.out.println("��ǰ�����Ѿ��������");
		} else {
			lineUpList.remove(musicName);// �Ƴ�ָ���ĸ���
			lineUpList.add(postion - 1, musicName);// ��ָ���ĸ����ŵ�ǰһλ
		}
		System.out.println("�ѽ�����" + musicName + "��ǰһλ");
	}

	// �˳�
	private static void exit() {
		System.out.println("---------------�˳�---------------");
		System.out.println("�����˳�ϵͳ");
		System.exit(0);
	}
}
