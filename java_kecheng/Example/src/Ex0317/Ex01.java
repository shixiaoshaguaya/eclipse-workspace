package Ex0317;

/*
 * 类的继承
 */
//定义Animal类，作为父类
class Animal01 {
	String name;// 定义name属性

	// 定义动物叫的方法
	public void shout() {
		System.out.println("动物发出叫声");
	}
}

//定义Dog类继承Animal类，关键字extends
class Dog01 extends Animal01 {
	// 定义一个打印name属性的方法
	public void prinyName() {
		System.out.println("name=" + name);
	}
}

//定义测试类
public class Ex01 {
	public static void main(String[] args) {
		Dog01 dog = new Dog01();// 创建一个Dog类的对象，子类的对象
		dog.name = "沙皮狗";// 为Dog类的name属性进行赋值
		dog.prinyName();// 调用Dog类的输出名字的方法
		dog.shout();// 调用Dog类继承的父类的方法
	}
}
