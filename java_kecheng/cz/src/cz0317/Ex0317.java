package cz0317;

class Animal {
	String name;// 定义String型的name变量

	// 定义Animal的无参构造方法
	public Animal() {
		System.out.println("我是一只动物");
	}

	// 定义Animal的有参构造方法
	public Animal(String name) {
		System.out.println("我是一只" + name);
	}

	// 定义动物叫的方法shout（）
	public void shout() {
		System.out.println("动物发出叫声");
	}
}

//定义Dog类继承Animal类
class Dog extends Animal {
	// 定义一个打印name属性的方法printName（）
	public void printName() {
		System.out.println("name=" + name);
	}

	// 重写父类的shout（）方法
	public void shout() {
		System.out.println("汪汪汪...");
	}

	// 定义Dog的无参构造方法
	public Dog() {
		super("沙皮狗");
	}

	// 定义Dog的有参构造方法
	public Dog(String name) {
		super(name);
	}
}

//定义测试类Ex0317
public class Ex0317 {
	public static void main(String[] args) {
		Dog d1 = new Dog();
		// d1.name = "沙皮狗";
		d1.printName();
		d1.shout();
		Dog d2 = new Dog("土狗");
		d2.shout();
	}
}
