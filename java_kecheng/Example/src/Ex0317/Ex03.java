package Ex0317;

/*
 * super�ؼ���
 * �����У����ʸ���ĳ�Ա
 * �����Ա�������͸���ĳ�Ա����
 * 
 * ��̬�����У�������ʹ��this��super�ؼ���
 */
//����Animal��Ϊ����
class Animal03 {
	String name = "����";

	// ���嶯��еķ���
	public void shout() {
		System.out.println("���﷢������");
	}
}

//����Dog��̳�Animal����
class Dog03 extends Animal03 {
	String name = "Ȯ��";

	// ��д����ķ���shout����
	public void shout() {
		// ���ʸ���ķ���shout����
		// super.���෽������
		super.shout();
	}

	// �����ӡname���Եķ���
	public void printName() {
		System.out.println("name=" + super.name);// ���ʸ���ĳ�Ա����name
	}
}

//���������
public class Ex03 {
	public static void main(String[] args) {
		Dog03 dog = new Dog03();// ����Dog���������Ķ���
		dog.shout();// ����Dog���еķ���shout
		dog.printName();// ����Dog��ķ���printName
	}
}
