package Ex0324;

/*
 * ��̬�е�ת��
 */
//����Animal�ӿ�
interface Animal02 {
	// ������󷽷�shout����
	public abstract void shout();
}

//����Cat��ʵ��Animal�ӿ�
class Cat02 implements Animal02 {
	// ʵ��shout��������
	public void shout() {
		System.out.println("����...");
	}

	// ����sleep��������
	public void sleep() {
		System.out.println("è˯��...");
	}
}

//���������
public class Ex02 {
	public static void main(String[] args) {
		Cat02 cat = new Cat02();// ����Cat��Ķ���
		animalShout02(cat);// ����animalShout������������cat��Ϊ��������
	}

	// ���徲̬����animalShout����������һ��Animal���͵Ĳ���
	public static void animalShout02(Animal02 animal) {
		animal.shout();// ���ô������Animal��Shout��������
		//animal.sleep();// ���ܵ�����������з���
		
		Cat02 cat = (Cat02)animal;
		cat.sleep();
	}
}
