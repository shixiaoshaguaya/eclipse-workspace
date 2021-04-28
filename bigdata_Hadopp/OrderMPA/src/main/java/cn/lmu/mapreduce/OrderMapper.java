package cn.lmu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//1.继承于Mapper类
//2.输入类型、输出类型
//<keyin,keyvalue> :<文本的偏移量，读取一行内容>即<LongWritable,Text>
//<keyout,valueout>:<产品ID,产品订单信息>即<Text,OrderInfo>
//Mapper阶段对每行订单进行读取转换为OrderInfo对象
public class OrderMapper extends Mapper<LongWritable, Text, Text, OrderInfo> {
	OrderInfo oi;
	Text k = new Text();

	// 开发中一般重点改写map()方法来定义对数据的映射操作
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();// 获取输入的一行
		String[] values = line.split(",");
		oi = new OrderInfo();// 创建订单实例对象
		oi.setOrder_id(values[0]);
		oi.setProduct_id(values[1]);
		oi.setBuyNum(Integer.parseInt(values[2]));
		oi.setBuyPrice(Float.parseFloat(values[3]));
		oi.setBuyMoney(oi.getBuyPrice() * oi.getBuyNum());
		oi.setBuyCount(1);
		k.set(values[1]);// 产品ID作为Key
		context.write(k, oi);// 订单信息OrderInfo作为Value
	}

}
