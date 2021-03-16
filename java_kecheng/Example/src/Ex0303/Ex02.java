package Ex0303;

/*
 * 创建对象，访问对象中的成员
 */
public class Ex02 {
	public static void main(String[] args) {
		Ex01 p1 = new Ex01(); // 创建第一个Ex01类对象
		Ex01 p2 = new Ex01(); // 创建第二个Ex01类对象
		p1.age = 18; // 为age属性赋值
		p1.speak(); // 调用对象的方法
		p2.speak();
	}
}
