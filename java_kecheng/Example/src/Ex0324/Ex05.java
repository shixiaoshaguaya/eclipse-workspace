package Ex0324;

/*
 * Object类中toString（）方法的重写
 */
//定义Animal类
class Animal05 {
	//重写Object类的同String（）方法
	public String toString() {
		return "这是一个动物。。。";
	}
}

//定义测试类
public class Ex05 {
	public static void main(String[] args) {
		Animal05 animal = new Animal05();// 创建Animal类对象
		System.out.println(animal.toString());// 调用同String（）方法并打印
	}
}
