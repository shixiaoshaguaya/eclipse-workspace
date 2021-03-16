package cz0324;

//定义Animal接口
interface Animal {
	// 定义抽象方法shout（）
	public abstract void shout();
}

//定义Cat类实现Animal接口
class Cat implements Animal {
	// 实现shout（）方法
	public void shout() {
		System.out.println("喵喵...");
	}

	// 定义sleep（）方法
	public void sleep() {
		System.out.println("猫睡觉...");
	}
}

//定义测试类
public class Ex0324 {
	// 定义一个静态animalShout（Animal an）方法
	public static void animalShout(Animal an) {
		an.shout();
	}

	public static void main(String[] args) {
		// 定义一个内部类Dog实现Animal接口
		class Dog implements Animal {
			// 实现shout（）方法
			public void shout() {
				System.out.println("汪汪...");
			}
		}
		animalShout(new Dog());// 调用animalShot（）方法输出叫声
		Cat c1 = new Cat();// 创建Cat类的实例对象c1
		animalShout(c1);// 调用animalShout（）方法
		c1.sleep();// 调用sleep（）方法
		System.out.println(c1.toString());// 调用toString（）并打印
	}
}
