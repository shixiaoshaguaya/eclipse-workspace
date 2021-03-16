package cz0225;

/*
 * if..else if...else语句的使用
 */
public class Example09 {
	public static void main(String[] args) {
		int grade = 75; // 定义学生成绩
		if (grade > 80) {
			// 满足条件>80
			System.out.println("该成绩的等级为优");
		} else if (grade > 70) {
			// 不满足>80,但是满足>70
			System.out.println("该成绩的等级为良");
		} else if (grade > 60) {
			// 不满足>70,但是满足>60
			System.out.println("该成绩的等级为中");
		} else {
			System.out.println("该成绩的等级为差");
		}
	}
}
