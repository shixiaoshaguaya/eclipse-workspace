package cz0303;

/*
 * ʵ����ķ�װ                     
 */
class Student {
	private String name;// ����String���͵�name���������ҽ�name����˽�л�
	private int age;// ����int���͵�age���������ҽ�age����˽�л�
	// �����ǹ��е� getXxx �� setXxx ����

	public String getName() {
		return name;
	}

	public void setName(String setName) {
		name = setName;
	}

	public int getage() {
		return age;
	}

	public void setAge(int stuAge) {
		// �����Ǵ���Ĳ������м��
		if (stuAge <= 0) {
			System.out.println("�Բ�������������䲻�ͷ�");
		} else {
			age = stuAge;// �����Ը�ֵ
		}
	}

	public void introduce() {
		// �����д�ӡ����name��age��ֵ
		System.out.println("��Һã��ҽ�" + name + "���ҽ���" + age + "��");
	}
}

public class Ex304 {
	public static void main(String[] args) {
		Student w = new Student();
		w.setName("��");
		w.setAge(19);
		w.introduce();
	}
}