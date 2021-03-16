package Ex0310;

/*
 * 构造方法的重载
 */
class Per03 {
	private String name;
	private int age;

	// 定义两个参数的构造方法
	public Per03(String con_name, int con_age) {
		name = con_name;
		age = con_age;
	}

	// 定义一个参数的构造方法
	public Per03(String con_name) {
		name = con_name;
	}

	public void speak() {
		// 打印name和age的值
		System.out.println("大家好，我叫" + name + ",我今年" + age + "岁");
	}
}

public class Ex03 {
	public static void main(String[] args) {
		// 分别创建两个对象p1和p2
		Per03 p1 = new Per03("小明");
		Per03 p2 = new Per03("小红", 20);
		// 通过对象p1和p2调用speak方法
		p1.speak();
		p2.speak();
	}
}
