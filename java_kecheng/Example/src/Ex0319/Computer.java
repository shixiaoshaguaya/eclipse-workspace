package Ex0319;

/*
 * ������
 *  �кܶ�USB���
 *  ����USB�豸����
 *  �������ܣ��ػ�����
 */
public class Computer {
	// �����ϵ�USB���
	private USB[] usbArr = new USB[4];

	// �����������USB�豸
	public void add(USB usb) {
		// �������飬��ȡ���ԵĲ��
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] == null) {
				// ���豸������USB�����
				// ��USB�ӿ�ʵ������󣬴洢����USB��������
				usbArr[i] = usb;
				break;
			}
		}
	}

	// ���ԵĿ�������
	public void powerOn() {
		// ѭ���������Բ��
		for (int i = 0; i < usbArr.length; i++) {
			// ������������д洢��USB�ӿ�ʵ�������
			if (usbArr[i] != null) {
				// �����豸�ϵĿ�������
				usbArr[i].turnOn();
			}
		}
		System.out.println("���Կ����ɹ�");
	}

	// ���Թػ�����
	public void powerOff() {
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] != null) {
				usbArr[i].turnOff();
			}
		}
		System.out.println("���Թػ��ɹ�");
	}
}
