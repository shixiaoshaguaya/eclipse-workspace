package Ex0317;

/*
 * final修饰变量，一次赋值，终身不变
 */
public class Ex07 {
	public static void main(String[] args) {
		final int num = 2;// 第一次可以赋值
		//num = 4;// 再次赋值，编译失败
	}
}
