package Ex0324;

//����Animal�ӿ�
interface Animal07 {
	public void shout();// ������󷽷�
}

//���������
public class Ex07 {
	public static void main(String[] args) {
		// ���������ڲ�����Ϊ�������ݸ�animalShout��������
		animalShout(new Animal06() {
			// ʵ��shout��������
			public void shout() {
				System.out.println("����...");
			}
		});
	}

	// ���徲̬����animalShout����
	public static void animalShout(Animal06 an) {
		an.shout();// ���ô������an��shout��������
	}
}
