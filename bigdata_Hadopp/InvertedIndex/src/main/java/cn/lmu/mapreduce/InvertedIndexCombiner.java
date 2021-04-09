package cn.lmu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import cn.lmu.utils.StringUtil;

/*
* Conbiner类
*
* 输入<word:filename, value>格式，如<hello:a.txt, 1>
* <hello:a.txt, 1>
* <hello:b.txt, 1>
*
* 输出<word, filename:values>格式，如<hello, a.txt:2>
* <hello, b.txt:1>
*/
public class InvertedIndexCombiner extends Reducer<Text, Text, Text, Text> {
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		long sum = 0;
		// 统计同一个单词在同一个文件中的次数
		for (Text val : values) {
			sum += Integer.valueOf(val.toString());
		}
		// 将key(hello:a.txt) 分割为newKey(hello)和fileKey(a.txt)
		String newKey = StringUtil.getSplitByIndex(key.toString(), ":", 0);
		String fileKey = StringUtil.getSplitByIndex(key.toString(), ":", 1);
		context.write(new Text(newKey), new Text(fileKey + ":" + String.valueOf(sum)));
	}

}
