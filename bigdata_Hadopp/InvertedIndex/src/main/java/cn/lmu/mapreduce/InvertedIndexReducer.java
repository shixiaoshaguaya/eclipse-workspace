package cn.lmu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
* Recuder类
*
* 输入<word, filename:values>格式，如<hello, a.txt:2>
* <hello, b.txt:1>
*
* 输出<word, filename1:values;filename2:values>格式,如<hello, a.txt:2;b.txt:1>
*/
public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		StringBuilder sb = new StringBuilder();
		// 聚合同一单词出现在的文件及出现次数
		for (Text val : values) {
			sb.append(val.toString() + ";");
		}
		context.write(key, new Text(sb.toString()));
	}
}
