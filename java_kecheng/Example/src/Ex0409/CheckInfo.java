package Ex0409;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class CheckInfo {
	public static HashSet<User> USER_DATA = new HashSet<User>();// �û�����

	public CheckInfo(HashSet<User> USER_DATA) {
		this.USER_DATA = USER_DATA;
	}

	// У���û���Ϣ�����ص�¼״̬��Ϣ
	public String checkAction(String userNAme, String password, String rePassWord, String biethday, String phone,
			String email) {
		StringBuilder result = new StringBuilder();
		// 1 ����ɹ� 2 ����ʧ��
		int state = 1;
		// �����ж�
		if (!password.equals(rePassWord)) {
			result.append("�����������벻һ�£�\r\n");
			state = 2;
		}
		// �����ж�
		if (biethday.length() != 10) {// �ַ������Ȳ�Ϊ10������Ϊ��ʽ����
			result.append("���ո�ʽ����ȷ��\r\n");
			state = 2;
		} else {
			for (int i = 0; i < biethday.length(); i++) {
				Character thisChar = biethday.charAt(i);
				if (i == 4 || i == 7) {
					if (!(thisChar == '-')) {// ��֤��4λ�͵�7λ�Ƿ��Ƿ���
						result.append("���ո�ʽ����ȷ��\r\n");
						state = 2;
					}
				} else {// ��֤���˵�4λ�͵�7λ���ַ��Ƿ���0~9������
					if (!(Character.isDigit(thisChar))) {
						result.append("���ո�ʽ����ȷ��\r\n");
						state = 2;
					}
				}
			}
		}
		// �ֻ����ж�
		if (phone.length() != 11) {// �ж��ֻ��ų��Ȳ�����11λ����Ϊ���ֻ�����Ч
			result.append("�ֻ����벻��ȷ��\r\n");
			state = 2;
			// Ĭ����Ч�ֻ���Ϊ13��15��17��18��ͷ���ֻ���
		} else if (!(phone.startsWith("13") || phone.startsWith("15") || phone.startsWith("17")
				|| phone.startsWith("18"))) {
			result.append("�ֻ����벻��ȷ��\r\n");
			state = 2;
		}
		// �����ж�
		if (!email.contains("@")) {
			result.append("���䲻��ȷ��\r\n");
			state = 2;
		}
		// ���������Ϣ�������������û����뵽����
		if (state == 1) {
			// ��ʽ�����ڷ���Date����
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBirthday = null;
			try {
				dateBirthday = format.parse(biethday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			User newUser = new User(userNAme, rePassWord, dateBirthday, phone, email);
			// ���û���ӵ��б��У�ͬʱ�ɸ���HashSet�жϳ��û�����û���ظ�
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
