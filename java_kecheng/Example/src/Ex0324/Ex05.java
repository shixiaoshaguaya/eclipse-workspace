package Ex0324;

/*
 * Object����toString������������д
 */
//����Animal��
class Animal05 {
	//��дObject���ͬString��������
	public String toString() {
		return "����һ���������";
	}
}

//���������
public class Ex05 {
	public static void main(String[] args) {
		Animal05 animal = new Animal05();// ����Animal�����
		System.out.println(animal.toString());// ����ͬString������������ӡ
	}
}
