package Ex0310;

/*
 *静态的变量 
 */
class Per08 {
	static String shoolName;// 定义静态变量shollName
}

public class Ex08 {
	public static void main(String[] args) {
		Per08 stu1 = new Per08();// 创建学生对象
		Per08 stu2 = new Per08();
		// 静态成员的调用方法，类名.对象
		Per08.shoolName = "测试类";
		System.out.println("我的学校是：" + stu1.shoolName);// 打印第一个学生对象的学校名
		System.out.println("我的学校是：" + stu2.shoolName);// 打印第二个学生对象的学校名
	}
}
