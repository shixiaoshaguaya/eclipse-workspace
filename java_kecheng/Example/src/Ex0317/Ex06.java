package Ex0317;

/*
 * final修饰方法，被final修饰的方法，最终方法，不能被子类重写
 */
//定义Animal父类
class Animal06 {
	// 使用final关键字修饰的shout（）方法后，如果子类重写这个方法，编译报错
	// public final void shout() {
	public void shout() {

	}
}

//定义Dog类继承父类
class Dog06 extends Animal06 {
	public void shout() {

	}
}

public class Ex06 {
	public static void main(String[] args) {
		Dog06 dog = new Dog06();// 创建Dog类的对象
	}
}
