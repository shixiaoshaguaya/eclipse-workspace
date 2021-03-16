package Ex0324;

/*
 * 对象的多态性
 * 父类或者是接口引用= new 子类的对象
 */
//定义接口Animal
interface Animal01 {
	public abstract void shout();// 定义抽象方法
}

//定义Cat类实现Animal接口
class Cat01 implements Animal01 {
	// 实现shout方法
	public void shout() {
		System.out.println("喵喵...");
	}

}

//定义Dog类实现Animal接口
class Dog01 implements Animal01 {
	// 实现shout方法
	public void shout() {
		System.out.println("汪汪...");
	}
}

//定义测试类，多态
public class Ex01 {
	public static void main(String[] args) {
		Animal01 an1 = new Cat01();// 创建Cat对象，使用Animal类型的an1引用
		Animal01 an2 = new Dog01();// 创建Dog对象，使用Animal类型的an2引用
		animalShout01(an1);// 调用animalShout（）方法，将an1作为参数传递
		animalShout01(an2);// 调用animalShout（）方法，将an2作为参数传递
	}

	// 定义静态的animalShout方法，接收一个Animal类型的参数
	// 参数，可以接收的是Animal接口的任何实现类对象
	public static void animalShout01(Animal01 an) {
		an.shout();// 调用实际参数Shout（）方法
	}
}
