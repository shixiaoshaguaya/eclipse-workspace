package Ex0324;

/*
 * 多态中的转型
 */
//定义Animal接口
interface Animal03 {
	// 定义抽象方法shout（）
	public abstract void shout();
}

//定义Cat类实现Animal接口
class Cat03 implements Animal03 {
	// 实现shout（）方法
	public void shout() {
		System.out.println("喵喵...");
	}

	// 定义sleep（）方法
	public void sleep() {
		System.out.println("猫睡觉...");
	}
}

//定义Dog类实现Animal接口
class Dog03 implements Animal03{
	//实现shout（）方法
	public void shout() {
		System.out.println("汪汪...");
	}
}

//定义测试类
public class Ex03 {
	public static void main(String[] args) {
		Dog03 dog = new Dog03();// 创建Dog类的对象
		animalShout03(dog);// 调用animalShout（）方法，将cat作为参数传入
	}

	// 定义静态方法animalShout（），接收一个Animal类型的参数
	public static void animalShout03(Animal03 animal) {
		// 对传递的参数animal进行判断，如果是Cat对象，强制转成Cat类
		if(animal instanceof Cat03) {
			Cat03 cat = (Cat03)animal;
			cat.shout();
			cat.sleep();
		}else {
			System.out.println("this animal is not cat");
		}
	}
}