package cz0407;

import java.util.LinkedList;
import java.util.Scanner;

public class KTV_LinkedList {
	public static void main(String[] args) {
		System.out.println("----------��ӭ�������ϵͳ---------------");
		System.out.println("0.��Ӹ������б�");
		System.out.println("1.�������ö�");
		System.out.println("2.������ǰ��һλ");
		System.out.println("3.�˳�");
		LinkedList lineUpList = new LinkedList();// ���������б�
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
	private static void addMusicList(LinkedList lineUpList) {
		lineUpList.add("ϲ����");
		lineUpList.add("�ؼ���");
		lineUpList.add("Ů����");
		lineUpList.add("��ɽ");
		lineUpList.add("ҹɫ");
		System.out.println("��ʼ�����б�" + lineUpList);
	}

	// ִ����Ӹ���
	private static void addMusic(LinkedList lineUpList) {
		System.out.print("������Ҫ��ӵĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		lineUpList.addLast(musicName);// ��Ӹ������б�����
		System.out.println("����Ӹ�����" + musicName);
	}

	// ִ�н������ö�
	private static void setTop(LinkedList lineUpList) {
		System.out.print("������Ҫ�ö��ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		int postion = lineUpList.indexOf(musicName);// ����ָ������λ��
		if (postion < 0) {// �ж���������Ƿ����
			System.out.println("��ǰ�б���û������ĸ�����");
		} else {
			lineUpList.remove(musicName);// �Ƴ�ָ���ĸ���
			lineUpList.addFirst(musicName);// ��ָ���ĸ����ŵ���һλ
		}
		System.out.println("�ѽ�����" + musicName + "�ö�");
	}

	// ִ�н�������ǰһλ
	private static void setBefore(LinkedList lineUpList) {
		System.out.print("������Ҫ��ǰ�ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		int postion = lineUpList.indexOf(musicName);// ����ָ������λ��
		if (postion < 0) {// �ж���������Ƿ����
			System.out.println("��ǰ�б���û������ĸ�����");
		} else if (postion == 0) {
			System.out.println("��ǰ�����Ѿ��������");
		} else {
			lineUpList.remove(musicName);// �Ƴ�ָ���ĸ���
			lineUpList.addFirst(musicName);// ��ָ���ĸ����ŵ�ǰһλ
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
