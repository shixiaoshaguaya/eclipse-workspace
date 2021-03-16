package Ex0317;

/*
 * final修饰成员变量
 */
//定义Student类
class Student {
	final String name = "韩强";// 为成员变量赋值
	
	// 定义introduce方法，打印学生信息
	public void introduce() {
		System.out.println("我叫" + name + "是传智播客学生");
	}
}

//定义测试类
public class Ex08 {
	public static void main(String[] args) {
		Student stu = new Student(); // 创建Student类的对象
		stu.introduce();// 调用Student类中的方法
	}
}
