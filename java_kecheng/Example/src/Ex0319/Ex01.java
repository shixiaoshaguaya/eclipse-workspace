package Ex0319;

/*
 * 抽象类的使用
 */
//定义抽象类Animal
abstract class Animal01 {
	public abstract void shout();
}

//定义Dog类继承Animal抽象类
class Dog01 extends Animal01 {
	// 重写父类的抽象方法，实现抽象方法
	public void shout() {
		System.out.println("汪汪...");
	}
}

//定义的测试类
public class Ex01 {
	public static void main(String[] args) {
		Dog01 dog = new Dog01();// 创建Dog类的对象，创建的是抽象类的子类对象
		dog.shout();
	}
}
