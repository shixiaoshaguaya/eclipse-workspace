package Ex0416;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordBooksOrder {
	static ArrayList<Books> booksList = new ArrayList<Books>();// 创建书架

	public static void main(String[] args) {
		init();// 初始化书架
		// 将书架上所以图书信息打印出来
		for (int i = 0; i < booksList.size(); i++) {
			System.out.println(booksList.get(i));
		}
		while (true) {
			// 获取控制台输入的信息
			Scanner scan = new Scanner(System.in);
			System.out.print("请输入图书编号：");
			int bookId = scan.nextInt();
			Books stockBooks = getbooksById(bookId);
			if (stockBooks != null) {// 判断是否在此图书
				System.out.println("当前图书信息" + stockBooks);
				System.out.print("请输入购买数量：");
				int bookNumber = scan.nextInt();
				if (bookNumber <= stockBooks.number) {// 判断库存是否足够
					// 将输入信息封装成Books对象
					Books books = new Books(stockBooks.id, stockBooks.name, stockBooks.price, bookNumber,
							stockBooks.price * bookNumber, stockBooks.Publish);
					FileUtil.saveBooks(books);// 将本条数据保存至本地文件
					// 修改库存
					stockBooks.setNumber(stockBooks.number - bookNumber);
				} else {
					System.out.println("库存不足！");
				}
			} else {
				System.out.println("图书编号输入错误！");
			}
		}
	}

	/**
	 * 初始化书架上图书的信息 将图书到书架上
	 */

	private static void init() {
		Books goodsl = new Books(101, "Java基础入门", 44.50, 100, 4450.00, "清华大学出版社");
		Books goods2 = new Books(102, "Java编程思想", 108.00, 50, 5400.00, "机械工业出版社");
		Books goods3 = new Books(102, "Java编程思想", 99.00, 100, 9900.00, "电子工业出版社");
		booksList.add(goodsl);
		booksList.add(goods2);
		booksList.add(goods3);
	}

	/**
	 * 根据输入的图书编号查找图书信息 循环遍历书架中图书信息，找到图书编号相等的取出
	 */

	private static Books getbooksById(int bookId) {
		for (int i = 0; i < booksList.size(); i++) {
			Books thisBooks = booksList.get(i);
			if (bookId == thisBooks.id) {
				return thisBooks;
			}
		}
		return null;
	}
}
