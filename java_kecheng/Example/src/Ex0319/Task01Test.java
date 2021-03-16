package Ex0319;

/*
 * 测试类
 */
public class Task01Test {
	public static void main(String[] args) {
		// 创建电脑类对象
		Computer c = new Computer();
		// 向电脑中添加USB设备，鼠标、键盘和麦克风设备
		c.add(new Mouse());
		c.add(new Mic());
		c.add(new KeyBoard());
		c.powerOn();// 调用电脑的启动方法
		System.out.println();
		c.powerOff();// 调用电脑的关机方法
	}
}
