package cn.lmu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//1.必须继承于Reducer父类
//参数：<keyin,valuein> <keyout,valueout>
//Reduce阶段的输入来自于Map阶段的结果
//<OrderInfo,1>
public class OrderReducer extends Reducer<Text, OrderInfo, OrderInfo, NullWritable> {
	OrderInfo oi;

	// 对Map阶段处理结果进行规约归并统计
	// <productID1,OrderInfo1>
	// <productID1,OrderInfo2>
	@Override
	protected void reduce(Text key, Iterable<OrderInfo> values, Context context)
			throws IOException, InterruptedException {
		// 1 累计同一产品求和:
		oi = new OrderInfo();
		int buyNum = 0;
		float buyPrice = 0;
		float buyMoney = 0;
		int buyCount = 0;
		// 对同一产品（同一个Key被归并在一起）的所有订单进行汇总统计
		for (OrderInfo oItem : values) {
			buyNum += oItem.getBuyNum();// 累加购买数量
			buyMoney += oItem.getBuyMoney();// 累加购买金额
			buyCount += oItem.getBuyCount();// 累加购买笔数
		}
		oi.setProduct_id(key.toString());
		oi.setBuyNum(buyNum);
		oi.setBuyMoney(buyMoney);
		oi.setBuyCount(buyCount);
		buyPrice = oi.getBuyMoney() / oi.getBuyNum();// 统计平均购买价格
		oi.setBuyPrice(buyPrice);
		// 2 输出 <OrderInfo,>
		context.write(oi, NullWritable.get());// 每个产品输出一个OrderInfo信息
	}
}
