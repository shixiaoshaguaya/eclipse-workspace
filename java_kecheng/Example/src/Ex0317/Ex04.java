package Ex0317;

/*
 * super（父类构造方法的参数）访问父类的构造方法：必须是子类构造方法，才能调用父类构造方法
 */
//定义Animal作为父类
class Animal04 {
	// 定义Animal类有参的构造方法
	public Animal04(String name) {
		System.out.println("我是一只" + name);
	}
}

//定义Dog类继承Animal父类
class Dog04 extends Animal04 {
	public Dog04() {
		super("沙皮狗");
	}
}

//定义测试类
public class Ex04 {
	public static void main(String[] args) {
		Dog04 dog = new Dog04();// 创建Dog类的对象，子类对象
	}
}
