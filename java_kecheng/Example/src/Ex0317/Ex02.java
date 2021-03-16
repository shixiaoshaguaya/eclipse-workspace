package Ex0317;

/*
 * 子类继承父类后，方法重写
 * 子类重写父类方法:保证子类的权限必须大于或者等于父类方法权限
 */
//定义Animal作为父类
class Animal02 {
	// 定义动物叫方法
	void shout() {
		System.out.println("动物发出声音");
	}
}

//定义Dog类继承动物类
class Dog02 extends Animal02 {
	// 定义狗叫的方法
	void shout() {
		System.out.println("汪汪汪...");
	}
}

//定义测试类
public class Ex02 {
	public static void main(String[] args) {
		Dog02 dog = new Dog02();// 创建Dog类的对象，子类对象
		dog.shout();// 调用Dog类重写的父类方法shout
	}
}
