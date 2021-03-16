package Ex0324;

//定义Animal接口
interface Animal07 {
	public void shout();// 定义抽象方法
}

//定义测试类
public class Ex07 {
	public static void main(String[] args) {
		// 定义匿名内部类作为参数传递给animalShout（）方法
		animalShout(new Animal06() {
			// 实现shout（）方法
			public void shout() {
				System.out.println("喵喵...");
			}
		});
	}

	// 定义静态方法animalShout（）
	public static void animalShout(Animal06 an) {
		an.shout();// 调用传入对象an的shout（）方法
	}
}
