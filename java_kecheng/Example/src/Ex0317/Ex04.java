package Ex0317;

/*
 * super�����๹�췽���Ĳ��������ʸ���Ĺ��췽�������������๹�췽�������ܵ��ø��๹�췽��
 */
//����Animal��Ϊ����
class Animal04 {
	// ����Animal���вεĹ��췽��
	public Animal04(String name) {
		System.out.println("����һֻ" + name);
	}
}

//����Dog��̳�Animal����
class Dog04 extends Animal04 {
	public Dog04() {
		super("ɳƤ��");
	}
}

//���������
public class Ex04 {
	public static void main(String[] args) {
		Dog04 dog = new Dog04();// ����Dog��Ķ����������
	}
}
