package Ex0324;

/*
 * Object���еķ���toSting����
 */
//����Animal��
class Animal04 {
	//���嶯��еķ���
	public void shout() {
		System.out.println("�����");
	}
}

//���������
public class Ex04 {
	public static void main(String[] args) {
		Animal04 animal = new Animal04();
		System.out.println(animal.toString());//����toString������������ӡ
	}
}
