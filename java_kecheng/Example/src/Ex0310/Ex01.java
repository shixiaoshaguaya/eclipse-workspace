package Ex0310;

/*
 * 构造方法定义
 */
class Per01 {
	public Per01() {
		System.out.println("无参的构造方法被调用了。。。");
	}
}

public class Ex01 {
	public static void main(String[] args) {
		Per01 p = new Per01();// 实例化Person对象
	}
}
