package hdfs;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class WriteHadoopFile1 {

	public static void main(String[] args) throws IOException {
		String filePath = "outfile/out.txt";
		Path pt = new Path(filePath);
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		System.out.println("하둡에 저장할 문자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		FSDataOutputStream out = fs.create(pt); // 존재하는 경우 : 덮어쓰기
		while (true) {
			String console = scan.nextLine();
			if (console.equals("exit")) break;
			out.writeBytes(console + "\n");
			out.flush();
		}
		out.close();
	}
	
}
