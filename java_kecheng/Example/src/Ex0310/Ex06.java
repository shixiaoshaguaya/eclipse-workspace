package Ex0310;

/*
 * this关键字
 * 用来对象引用
 * 在构造方法中调用其他构造方法
 */
class Per06 {
	private String name;

	public Per06() {
		this("默认名字");
	}

	public Per06(String name) {
		this.name = name;
	}

	public void speak() {
		System.out.println("大家好，我叫" + name);
	}
}

public class Ex06 {
	public static void main(String[] args) {
		Per06 p = new Per06();
		p.speak();
	}
}
