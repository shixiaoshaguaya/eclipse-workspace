package Ex0324;

/*
 * ����Ķ�̬��
 * ��������ǽӿ�����= new ����Ķ���
 */
//����ӿ�Animal
interface Animal01 {
	public abstract void shout();// ������󷽷�
}

//����Cat��ʵ��Animal�ӿ�
class Cat01 implements Animal01 {
	// ʵ��shout����
	public void shout() {
		System.out.println("����...");
	}

}

//����Dog��ʵ��Animal�ӿ�
class Dog01 implements Animal01 {
	// ʵ��shout����
	public void shout() {
		System.out.println("����...");
	}
}

//��������࣬��̬
public class Ex01 {
	public static void main(String[] args) {
		Animal01 an1 = new Cat01();// ����Cat����ʹ��Animal���͵�an1����
		Animal01 an2 = new Dog01();// ����Dog����ʹ��Animal���͵�an2����
		animalShout01(an1);// ����animalShout������������an1��Ϊ��������
		animalShout01(an2);// ����animalShout������������an2��Ϊ��������
	}

	// ���徲̬��animalShout����������һ��Animal���͵Ĳ���
	// ���������Խ��յ���Animal�ӿڵ��κ�ʵ�������
	public static void animalShout01(Animal01 an) {
		an.shout();// ����ʵ�ʲ���Shout��������
	}
}
