package Ex0317;

/*
 * super关键字
 * 子类中，访问父类的成员
 * 父类成员变量，和父类的成员方法
 * 
 * 静态方法中，不允许使用this和super关键字
 */
//定义Animal作为父类
class Animal03 {
	String name = "动物";

	// 定义动物叫的方法
	public void shout() {
		System.out.println("动物发出叫声");
	}
}

//定义Dog类继承Animal父类
class Dog03 extends Animal03 {
	String name = "犬类";

	// 重写父类的方法shout（）
	public void shout() {
		// 访问父类的方法shout（）
		// super.父类方法（）
		super.shout();
	}

	// 定义打印name属性的方法
	public void printName() {
		System.out.println("name=" + super.name);// 访问父类的成员变量name
	}
}

//定义测试类
public class Ex03 {
	public static void main(String[] args) {
		Dog03 dog = new Dog03();// 创建Dog类对象，子类的对象
		dog.shout();// 调用Dog类中的方法shout
		dog.printName();// 调用Dog类的方法printName
	}
}
