package Ex0319;

/*
 * ������
 */
public class Task01Test {
	public static void main(String[] args) {
		// �������������
		Computer c = new Computer();
		// ����������USB�豸����ꡢ���̺���˷��豸
		c.add(new Mouse());
		c.add(new Mic());
		c.add(new KeyBoard());
		c.powerOn();// ���õ��Ե���������
		System.out.println();
		c.powerOff();// ���õ��ԵĹػ�����
	}
}
