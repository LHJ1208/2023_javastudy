package day28.com.ict.edu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

// PrintStream : 1byte 처리, 모든 데이터 출력할 수 있음. (System.out.println())
//	BufferedOutStream처럼 OutputStream을 이용해서 사용 (체인 방식)

// PrintWriter : OutputStream(바이트 출력), Write(문자 출력) 둘 다 사용 가능

public class Ex01_PrintWriter {
	public static void main(String[] args) {
		String pathName = "D:/njm/exam100.txt";
		File file = new File(pathName);

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			pw.print("PrintWriter 연습");
			pw.print(123456);
			pw.print('A');
			pw.print(true);
			pw.print(178.95);

		} catch (Exception e) {
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (Exception e2) {
			}
		}

	}
}
