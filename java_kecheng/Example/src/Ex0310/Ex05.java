package Ex0310;

class Per05 {
	/*
	 * private关键字修饰的构造方法Person（）只能在Person类中被访问。
	 * 也就是说Person（）构造方法是私有的，不可以被外界调用，也就无法在类的外部创建该类的对象
	 * 构造方法一般情况下都是public权限，特殊要求的时候，类的构造方法私有化
	 */
	public Per05() {

	}
}

public class Ex05 {
	public static void main(String[] args) {
		Per05 p = new Per05();
	}
}
