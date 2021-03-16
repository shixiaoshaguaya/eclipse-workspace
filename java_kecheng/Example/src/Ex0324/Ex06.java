package Ex0324;

//定义Animal接口
interface Animal06 {
	public abstract void shout();// 定义抽象方法
}

//定义测试类
public class Ex06 {
	public static void main(String[] args) {
		// 定义一个内部类Cat实现Animal接口
		class Cat implements Animal06 {
			// 实现shout（）方法
			public void shout() {
				System.out.println("喵喵...");
			}
		}
		animalShout(new Cat());// 调用animalShout（）方法并传入Cat对象
	}

	// 定义静态方法animalShout（）
	public static void animalShout(Animal06 an) {
		an.shout();// 调用传入对象an的shout（）方法
	}
}
