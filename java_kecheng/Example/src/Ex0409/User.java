package Ex0409;

import java.util.Date;

//�û���Ϣ
public class User {
	private String userName;// �û���
	private String password;// ����
	private Date biethDay;// ����
	private String telNumber;// �ֻ�����
	private String email;// ����

	public User() {
	}

	public User(String userName, String password, Date biethDay, String telNumber, String email) {
		this.userName = userName;
		this.password = password;
		this.biethDay = biethDay;
		this.telNumber = telNumber;
		this.email = email;
	}

	// ��дhashCode��equals����
	public int hashCode() {// ��дhashCode���������û�����Ϊ�Ƿ��ظ�������
		return userName.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {// �ж��Ƿ���ͬһ������
			return true;// �����ͬһ������ֱ�ӷ���true
		}
		if (obj == null) {// �ж���������Ƿ�Ϊ��
			return false;// ��������ǿյģ�ֱ�ӷ���false
		}
		if (getClass() != obj.getClass()) {// �ж���������Ƿ���User����
			return false;// ������ǣ�ֱ�ӷ���false
		}
		User other = (User) obj;// ������ǿתΪUser����
		if (userName == null) {// �жϼ������û��Ƿ�Ϊ��
			if (other.userName != null) {// �жϼ������û����Ƿ�Ϊ��
				return false;// �������û���Ϊ���Ҷ������û�����Ϊ�գ��򷵻�false
			}
		} else if (!userName.equals(other.userName)) {// �ж��û����Ƿ���ͬ
			return false;// �����ͬ������false
		}
		return true;
	}
}
