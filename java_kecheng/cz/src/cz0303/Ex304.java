package cz0303;

/*
 * 实现类的封装                     
 */
class Student {
	private String name;// 定义String类型的name变量，并且将name属性私有化
	private int age;// 定义int类型的age变量，并且将age属性私有化
	// 下面是共有的 getXxx 和 setXxx 方法

	public String getName() {
		return name;
	}

	public void setName(String setName) {
		name = setName;
	}

	public int getage() {
		return age;
	}

	public void setAge(int stuAge) {
		// 下面是传入的参数进行检查
		if (stuAge <= 0) {
			System.out.println("对不起，您输入的年龄不和法");
		} else {
			age = stuAge;// 对属性赋值
		}
	}

	public void introduce() {
		// 方法中打印属性name和age的值
		System.out.println("大家好，我叫" + name + "，我今年" + age + "岁");
	}
}

public class Ex304 {
	public static void main(String[] args) {
		Student w = new Student();
		w.setName("陈喆");
		w.setAge(19);
		w.introduce();
	}
}