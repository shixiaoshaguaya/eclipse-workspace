package cz0319;

//定义USB接口
interface USB {
	// 定义抽象方法turnOn（）
	public abstract void turnOn();

	// 定义抽象方法turnOff（）
	public abstract void turnOff();
}

//定义鼠标类
class Mouse implements USB {
	// 实现turnOn（）方法
	public void turnOn() {
		System.out.println("鼠标启动了");
	}

	// 实现turnOff（）方法
	public void turnOff() {
		System.out.println("鼠标关闭了");
	}
}

//定义键盘类
class KeyBoard implements USB {
	// 实现turnOn（）方法
	public void turnOn() {
		System.out.println("键盘启动了");
	}

	// 实现turnOff（）方法
	public void turnOff() {
		System.out.println("键盘关闭了");
	}
}

//定义麦克风类
class MicroPhone implements USB {
	// 实现turnOn（）方法
	public void turnOn() {
		System.out.println("麦克风启动了");
	}

	// 实现turnOff（）方法
	public void turnOff() {
		System.out.println("麦克风关闭了");
	}
}

//定义计算机类
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
		System.out.println("计算机开机成功");
	}

	public void powerOff() {
		for (int i = 0; i < usbArr.length; i++) {
			if (usbArr[i] != null) {
				usbArr[i].turnOff();
			}
		}
		System.out.println("计算机关机成功");
	}
}

//定义测试类
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
