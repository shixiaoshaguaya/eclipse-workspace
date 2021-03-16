package cz0312;

//����������
class Bank {
	static String bankName;// ���徲̬������������
	private String name;// ��������
	private String password;// ����
	private double balance;// �˻����
	private double turnover;// ���׶�
	// ����˽�г�Աname���еķ��ʳ�Ա��getXxx()������setXxx()����

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ����˽�г�Աpassword���еķ��ʳ�Ա��getXxx()������setXxx()����
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// ����˽�г�Աbalance���еķ��ʳ�Ա��getXxx()������setXxx()����
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// ��̬������������л�ӭ���
	public static void welcome() {
		System.out.println("��ӭ����" + bankName);
	}

	// �����޲εĹ��췽��
	public Bank() {
	}

	// �������name��password��turnover�����Ĺ��췽����������
	public Bank(String name, String password, double turnover) {
		this.name = name;
		this.password = password;
		balance = balance + turnover - 10;
		System.out.println(name + "�����ɹ����˻����Ϊ" + balance + "����������Ϊ10");
	}

	// ����
	public double deposit(double turnover) {
		balance += turnover;
		System.out.println(name + "���ã�����˻��Ѿ�����" + turnover + "Ԫ��" + "���Ϊ" + balance + "Ԫ");
		return balance;
	}

	// ȡ���
	public void withdrawal(String password, double turnove) {
		// �ж������Ƿ���ȷ
		if (this.password != password) {
			System.out.println("��������������");
			return;
		}
		// �ж�����Ƿ����
		if (balance >= turnove) {
			balance -= turnove;
			System.out.println(name + "���ã������˻���ȡ��" + turnove + "Ԫ��" + "��ǰ���" + balance + "Ԫ");
		} else {
			System.out.println("�Բ����˻�����");
		}
	}

	// ��̬��������ӡ�����л�ӭ�´ι���
	public static void welcomeNext() {
		System.out.println("��Я������������ӭ�´ι���" + bankName);
	}
}

public class Trade {
	public static void main(String[] args) {
		// ����һ�����и���̬�������������ƣ���ֵ
		Bank.bankName = "����������";
		// ���д�ӡ��ӭ���
		Bank.welcome();
		// ��������
		Bank zs = new Bank("��", "654321", 1000.0);
		// ���д�����
		zs.deposit(500.0);
		// ȡ��ʱ�����������ȡ��ʧ��
		zs.withdrawal("123456", 200.0);
		// ȡ��ʱ���㣬ȡ��ʧ��
		zs.withdrawal("654321", 1500.0);
		// ȡ��ʱ������ȷ�������㣬ȡ��ɹ�
		zs.withdrawal("654321", 200.0);
		// ���д�ӡ�������
		Bank.welcomeNext();
	}
}
