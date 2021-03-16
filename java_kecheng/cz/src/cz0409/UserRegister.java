package cz0409;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

class User {
	private String userName;
	private String password;
	private Date biethDay;
	private String telNumber;
	private String email;

	public User() {
	}

	public User(String userName, String password, Date biethDay, String telNumber, String email) {
		this.userName = userName;
		this.password = password;
		this.biethDay = biethDay;
		this.telNumber = telNumber;
		this.email = email;
	}

	public int hashCode() {
		return userName.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}
}

class CheckInfo {
	public static HashSet<User> USER_DATA = new HashSet<User>();// �û�����

	public CheckInfo(HashSet<User> USER_DATA) {
		this.USER_DATA = USER_DATA;
	}

	public String checkAction(String userNAme, String password, String rePassWord, String biethday, String phone,
			String email) {
		StringBuilder result = new StringBuilder();
		int state = 1;

		if (!password.equals(rePassWord)) {
			result.append("�����������벻һ�£�\r\n");
			state = 2;
		}

		if (biethday.length() != 10) {
			result.append("���ո�ʽ����ȷ��\r\n");
			state = 2;
		} else {
			for (int i = 0; i < biethday.length(); i++) {
				Character thisChar = biethday.charAt(i);
				if (i == 4 || i == 7) {
					if (!(thisChar == '-')) {
						result.append("���ո�ʽ����ȷ��\\r\\n");
						state = 2;
					}
				} else {
					if (!(Character.isDigit(thisChar))) {
						result.append("���ո�ʽ����ȷ��\\r\\n");
						state = 2;
					}
				}
			}
		}
		if (phone.length() != 11) {
			result.append("�ֻ����벻��ȷ��\r\n");
			state = 2;
		} else if (!(phone.startsWith("13") || phone.startsWith("15") || phone.startsWith("17")
				|| phone.startsWith("18"))) {
			result.append("�ֻ����벻��ȷ��\r\n");
			state = 2;
		}
		if (!email.contains("@")) {
			result.append("���䲻��ȷ��\r\n");
			state = 2;
		}
		if (state == 1) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBirthday = null;
			try {
				dateBirthday = format.parse(biethday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			User newUser = new User(userNAme, rePassWord, dateBirthday, phone, email);

			if (!USER_DATA.add(newUser)) {
				result.append("�û��ظ���");
				state = 2;
			}
			if (state == 1) {
				result.append("ע��ɹ���");
			}
		}
		return result.toString();
	}
}

public class UserRegister {
	public static HashSet<User> USER_DATA = new HashSet<User>();// �û�����

	public static void main(String[] args) {
		initData();
		Scanner scan = new Scanner(System.in);
		System.out.print("�������û���");
		String userName = scan.nextLine();
		System.out.print("����������");
		String password = scan.nextLine();
		System.out.print("�������ظ�����");
		String repassword = scan.nextLine();
		System.out.print("��������");
		String birthday = scan.nextLine();
		System.out.print("�ֻ�����");
		String telNumber = scan.nextLine();
		System.out.print("��������");
		String email = scan.nextLine();

		CheckInfo checkInfo = new CheckInfo(USER_DATA);
		String result = checkInfo.checkAction(userName, password, repassword, birthday, telNumber, email);
		System.out.println("ע������" + result);
	}

	private static void initData() {
		User user = new User("����", "zz,123", new Date(), "18810319240", "zhangzheng@itcast.cn");
		User user1 = new User("����", "zq,123", new Date(), "18618121193", "zhouqi@itcast.cn");
		USER_DATA.add(user);
		USER_DATA.add(user1);
	}
}
