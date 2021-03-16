package Ex0319;

/*
 * 电脑类
 *  有很多USB插槽
 *  连接USB设备功能
 *  开机功能，关机功能
 */
public class Computer {
	// 电脑上的USB插槽
	private USB[] usbArr = new USB[4];

	// 向电脑上连接USB设备
	public void add(USB usb) {
		// 遍历数组，获取所以的插槽
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] == null) {
				// 将设备连接在USB插槽上
				// 将USB接口实现类对象，存储到了USB的数组中
				usbArr[i] = usb;
				break;
			}
		}
	}

	// 电脑的开机功能
	public void powerOn() {
		// 循环遍历所以插槽
		for (int i = 0; i < usbArr.length; i++) {
			// 如果发现数组中存储了USB接口实现类对象
			if (usbArr[i] != null) {
				// 调用设备上的开启功能
				usbArr[i].turnOn();
			}
		}
		System.out.println("电脑开机成功");
	}

	// 电脑关机功能
	public void powerOff() {
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] != null) {
				usbArr[i].turnOff();
			}
		}
		System.out.println("电脑关机成功");
	}
}
