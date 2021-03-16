package Ex0310;

/*
 * 有参构造方法
 */
class Per02 {
	private int age;

	// 定义有参构造方法
	public Per02(int a) {
		age = a;
	}

	public void speak() {
		System.out.println("我今年已经" + age + "岁了！");
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Per02 p = new Per02(20);// 实例化Per对象，传递构造方法实际参数
		p.speak();
	}
}
