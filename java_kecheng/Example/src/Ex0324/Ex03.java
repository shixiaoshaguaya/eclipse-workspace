package Ex0324;

/*
 * ��̬�е�ת��
 */
//����Animal�ӿ�
interface Animal03 {
	// ������󷽷�shout����
	public abstract void shout();
}

//����Cat��ʵ��Animal�ӿ�
class Cat03 implements Animal03 {
	// ʵ��shout��������
	public void shout() {
		System.out.println("����...");
	}

	// ����sleep��������
	public void sleep() {
		System.out.println("è˯��...");
	}
}

//����Dog��ʵ��Animal�ӿ�
class Dog03 implements Animal03{
	//ʵ��shout��������
	public void shout() {
		System.out.println("����...");
	}
}

//���������
public class Ex03 {
	public static void main(String[] args) {
		Dog03 dog = new Dog03();// ����Dog��Ķ���
		animalShout03(dog);// ����animalShout������������cat��Ϊ��������
	}

	// ���徲̬����animalShout����������һ��Animal���͵Ĳ���
	public static void animalShout03(Animal03 animal) {
		// �Դ��ݵĲ���animal�����жϣ������Cat����ǿ��ת��Cat��
		if(animal instanceof Cat03) {
			Cat03 cat = (Cat03)animal;
			cat.shout();
			cat.sleep();
		}else {
			System.out.println("this animal is not cat");
		}
	}
}