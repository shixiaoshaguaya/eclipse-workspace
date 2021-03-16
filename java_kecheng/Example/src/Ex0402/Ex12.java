package Ex0402;

/*
 * 拆箱：拆箱指将引用数据类型的对象转为基本数据类型
 * 
 * Integer类的方法
 * 	public int intValue（）以int类型返回该Integer的值
 */
public class Ex12 {
	public static void main(String[] args) {
		Integer num = new Integer(20);
		int a = 10;
		int sum = num.intValue() + a;
		System.out.println("sum=" + sum);
	}
}
