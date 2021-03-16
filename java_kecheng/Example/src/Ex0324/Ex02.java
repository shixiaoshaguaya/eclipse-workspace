package Ex0324;

/*
 * 多态中的转型
 */
//定义Animal接口
interface Animal02 {
	// 定义抽象方法shout（）
	public abstract void shout();
}

//定义Cat类实现Animal接口
class Cat02 implements Animal02 {
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
public class Ex02 {
	public static void main(String[] args) {
		Cat02 cat = new Cat02();// 创建Cat类的对象
		animalShout02(cat);// 调用animalShout（）方法，将cat作为参数传入
	}

	// 定义静态方法animalShout（），接收一个Animal类型的参数
	public static void animalShout02(Animal02 animal) {
		animal.shout();// 调用传入参数Animal的Shout（）方法
		//animal.sleep();// 不能调用子类的特有方法
		
		Cat02 cat = (Cat02)animal;
		cat.sleep();
	}
}
