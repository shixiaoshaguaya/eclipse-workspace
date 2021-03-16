package Ex0402;

/*
 * 装箱：装箱是指将基本数据类型的值转换为引用数据
 * 
 * 通过构造方法，完成装箱操作
 * 	int --> Integer
 * 	Integer(int n)
 */
public class Ex11 {
	public static void main(String[] args) {
		int a = 20;
		Integer in = new Integer(a);
		System.out.println(in.toString());
	}
}
