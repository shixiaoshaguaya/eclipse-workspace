package Ex0324;

/*
 * Object类中的方法toSting（）
 */
//定义Animal类
class Animal04 {
	//定义动物叫的方法
	public void shout() {
		System.out.println("动物叫");
	}
}

//定义测试类
public class Ex04 {
	public static void main(String[] args) {
		Animal04 animal = new Animal04();
		System.out.println(animal.toString());//调用toString（）方法并打印
	}
}
