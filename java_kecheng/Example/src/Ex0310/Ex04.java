package Ex0310;

/*
 * 默认构造方法
 */
class Per04 {
	private int age;

	/*
	 * 当类中定义了构造方法时，编译的时候就不会添加默认的构造方法 如果不定义无参数构造方法，定义有参数构造方法，创建对象的时候，必须传递参数
	 * 只要定义了构造方法，编译的时候默认构造方法将不再添加
	 */
	public Per04() {
	}// 无参构造方法

	public Per04(int x) {// 有参构造方法
		age = x;
	}
}

public class Ex04 {
	public static void main(String[] args) {
		Per04 p = new Per04();
	}
}
