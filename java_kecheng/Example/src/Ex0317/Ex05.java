package Ex0317;

/*
 * final修饰类，最终类，不能被继承
 */
/*final*/ class Animal05 {

}

class Dog05 extends Animal05 {

}

public class Ex05 {
	public static void main(String[] args) {
		Dog05 dog = new Dog05();// 创建Dog类的对象
	}
}
