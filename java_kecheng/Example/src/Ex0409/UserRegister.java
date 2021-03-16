package Ex0409;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class UserRegister {
	public static HashSet<User> USER_DATA = new HashSet<User>();// �û�����

	public static void main(String[] args) {
		initData();// ��ʼ����Ա��Ϣ
		Scanner scan = new Scanner(System.in);
		System.out.print("�������û���");
		String userName = scan.nextLine();// ��ȡ�û���
		System.out.print("����������");
		String password = scan.nextLine();// ��ȡ����
		System.out.print("�������ظ�����");
		String repassword = scan.nextLine();// ��ȡ�ظ�����
		System.out.print("��������");
		String birthday = scan.nextLine();// ��ȡ��������
		System.out.print("�ֻ�����");
		String telNumber = scan.nextLine();// ��ȡ�ֻ�����
		System.out.print("��������");
		String email = scan.nextLine();// ��ȡ��������
		// У���û���Ϣ�����ص�¼״̬��Ϣ
		CheckInfo checkInfo = new CheckInfo(USER_DATA);
		String result = checkInfo.checkAction(userName, password, repassword, birthday, telNumber, email);
		System.out.println("ע������" + result);
	}

	// ��ʼ�����ݣ����������Ѵ��ڵ��û���Ϣ
	private static void initData() {
		User user = new User("����", "zz,123", new Date(), "18810319240", "zhangzheng@itcast.cn");
		User user1 = new User("����", "zq,123", new Date(), "18618121193", "zhouqi@itcast.cn");
		USER_DATA.add(user);
		USER_DATA.add(user1);
	}
}
