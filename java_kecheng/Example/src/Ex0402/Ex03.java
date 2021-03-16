package Ex0402;

/*
 * arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
 * 	arraycopy()方法用于将一个数组中元素快速拷贝到另一个数组，其中的参数具体作用如下：
 * 	src：表示源数组。
 * 	dest：表示目标数组。
 * 	srcPos：表示源数组中拷贝元素的起始位置。
 * 	destPos：表示目标数据中的起始位置。
 * 	length：表示拷贝元素的个数。 
 */
public class Ex03 {
	public static void main(String[] args) {
		int[] fromArray = { 101, 102, 103, 104, 105, 106 };// 源数组
		int[] toArray = { 201, 202, 203, 204, 205, 206, 207 };// 目标数组
		// 拷贝数组元素，从fromArray数组2角标位置开始，拷贝4个元素，到toArray数组3角标位置
		System.arraycopy(fromArray, 2, toArray, 3, 4);
		// 打印toArray数组中的元素
		for (int i = 0; i < toArray.length; i++) {
			System.out.println(i + ":" + toArray[i]);
		}
	}
}
