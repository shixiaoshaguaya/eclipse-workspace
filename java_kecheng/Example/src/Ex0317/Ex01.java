package Ex0317;

/*
 * ��ļ̳�
 */
//����Animal�࣬��Ϊ����
class Animal01 {
	String name;// ����name����

	// ���嶯��еķ���
	public void shout() {
		System.out.println("���﷢������");
	}
}

//����Dog��̳�Animal�࣬�ؼ���extends
class Dog01 extends Animal01 {
	// ����һ����ӡname���Եķ���
	public void prinyName() {
		System.out.println("name=" + name);
	}
}

//���������
public class Ex01 {
	public static void main(String[] args) {
		Dog01 dog = new Dog01();// ����һ��Dog��Ķ�������Ķ���
		dog.name = "ɳƤ��";// ΪDog���name���Խ��и�ֵ
		dog.prinyName();// ����Dog���������ֵķ���
		dog.shout();// ����Dog��̳еĸ���ķ���
	}
}
