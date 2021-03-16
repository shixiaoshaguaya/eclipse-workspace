package cz0319;

//����USB�ӿ�
interface USB {
	// ������󷽷�turnOn����
	public abstract void turnOn();

	// ������󷽷�turnOff����
	public abstract void turnOff();
}

//���������
class Mouse implements USB {
	// ʵ��turnOn��������
	public void turnOn() {
		System.out.println("���������");
	}

	// ʵ��turnOff��������
	public void turnOff() {
		System.out.println("���ر���");
	}
}

//���������
class KeyBoard implements USB {
	// ʵ��turnOn��������
	public void turnOn() {
		System.out.println("����������");
	}

	// ʵ��turnOff��������
	public void turnOff() {
		System.out.println("���̹ر���");
	}
}

//������˷���
class MicroPhone implements USB {
	// ʵ��turnOn��������
	public void turnOn() {
		System.out.println("��˷�������");
	}

	// ʵ��turnOff��������
	public void turnOff() {
		System.out.println("��˷�ر���");
	}
}

//����������
class Computer {
	private USB[] usbArr = new USB[4];

	public void add(USB usb) {
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] == null) {
				usbArr[i] = usb;
				break;
			}
		}
	}

	public void powerOn() {
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] != null) {
				usbArr[i].turnOn();
			}
		}
		System.out.println("����������ɹ�");
	}

	public void powerOff() {
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] != null) {
				usbArr[i].turnOff();
			}
		}
		System.out.println("������ػ��ɹ�");
	}
}

//���������
public class Ex0319 {
	public static void main(String[] args) {
		Computer c = new Computer();
		c.add(new Mouse());
		c.add(new MicroPhone());
		c.add(new KeyBoard());
		c.powerOn();
		System.out.println();
		c.powerOff();
	}
}
