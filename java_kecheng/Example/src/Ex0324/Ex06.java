package Ex0324;

//����Animal�ӿ�
interface Animal06 {
	public abstract void shout();// ������󷽷�
}

//���������
public class Ex06 {
	public static void main(String[] args) {
		// ����һ���ڲ���Catʵ��Animal�ӿ�
		class Cat implements Animal06 {
			// ʵ��shout��������
			public void shout() {
				System.out.println("����...");
			}
		}
		animalShout(new Cat());// ����animalShout��������������Cat����
	}

	// ���徲̬����animalShout����
	public static void animalShout(Animal06 an) {
		an.shout();// ���ô������an��shout��������
	}
}
