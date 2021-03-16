package Ex0319;

/*
 * 接口的定义和使用
 */
//定义了Animal接口
interface Animal02 {
	// 定义全局常量，默认修饰符public static final
	public static final String ANIMAL_BEHAVIOR = "动物的行为";

	// 定义抽象方法breathe（）修饰符，固定为public abstract
	public abstract void breathe();

	// 定义抽象方法run（）
	public abstract void run();
}

//定义Dog类型实现Animal接口
class Dog02 implements Animal02 {
	// 重写接口抽象方法breathe（）
	public void breathe() {
		System.out.println(ANIMAL_BEHAVIOR + ":" + "狗在呼吸");
	}

	// 重写接口抽象方法run（）
	public void run() {
		System.out.println(ANIMAL_BEHAVIOR + ":" + "狗在奔跑");
	}
}

//定义测试类
public class Ex02 {
	public static void main(String[] args) {
		Dog02 dog = new Dog02();// 创建Dog类对象，是Animal接口的实现类的对象
		// 使用对象名.常量名的方式，输出接口中的常量
		// System.out.println(dog.ANIMAL_BEHAVIOR);
		// 接口名.常量名的方式，输出接口中的常量
		// System.out.println(Animal.ANIMAL_BEHAVIOR);
		dog.breathe();
		dog.run();
	}
}
