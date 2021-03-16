package cz0402;

import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
		// getProperties（）方法
		Properties properties = System.getProperties();
		System.out.println(properties);
		Set<String> propertyNAmes = properties.stringPropertyNames();
		for (String Key : propertyNAmes) {
			String value = System.getProperty(Key);
			System.out.println(Key + "--->" + value);
		}
		// currentTimeMilliss()方法
		long startTime = System.currentTimeMillis();// 循环开始时的当前时间
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long endTime = System.currentTimeMillis();// 循环结束的当前时间
		System.out.println("程序运行的时间为：" + (endTime - startTime) + "毫秒");
		// arraycopy（）方法
		int[] fromArray = { 101, 102, 103, 104, 105, 106 };
		int[] toArray = { 201, 202, 203, 204, 205, 206, 207 };
		System.arraycopy(fromArray, 2, toArray, 3, 4);
		for (int i = 0; i < toArray.length; i++) {
			System.out.println(i + ":" + toArray[i]);
		}
	}
}
