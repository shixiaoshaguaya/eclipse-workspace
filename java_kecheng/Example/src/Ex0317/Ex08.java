package Ex0317;

/*
 * final���γ�Ա����
 */
//����Student��
class Student {
	final String name = "��ǿ";// Ϊ��Ա������ֵ
	
	// ����introduce��������ӡѧ����Ϣ
	public void introduce() {
		System.out.println("�ҽ�" + name + "�Ǵ��ǲ���ѧ��");
	}
}

//���������
public class Ex08 {
	public static void main(String[] args) {
		Student stu = new Student(); // ����Student��Ķ���
		stu.introduce();// ����Student���еķ���
	}
}
