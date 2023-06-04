package day27.com.ict.edu;

import java.io.File;
import java.io.FileReader;

//FileInputStream => 1byte, read() => ASCII code(int), read(byte[] b)
//FileReader => 2byte, read() => Unicode(int), read(char[] b)
public class Ex05_Reader {
	public static void main(String[] args) {
		String pathname = "D:/njm/ex01.txt";
		File file = new File(pathname);

		FileReader fr = null;

		try {
			fr = new FileReader(file);

			// 한 글자 읽기
//			int ch = fr.read();
//			System.out.println(ch + " : " + (char)ch);

			// 전체 읽기
//			int k = 0;
//			while ((k = fr.read()) != -1) {
//				System.out.println(k + " : " + (char) k);
//			}

			// 배열 처리
//			char[] c = new char[(int)file.length()];
//			fr.read(c); //c배열에 모든 정보 저장됨
//			for (char k : c) {
//				System.out.println(k + " : " + (char) k);
//			}

			// String 이용
			char[] c = new char[(int) file.length()];
			fr.read(c); // c배열에 모든 정보 저장됨
			String msg = new String(c).trim();
			System.out.println(msg);
		} catch (Exception e) {
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
			}
		}
	}
}
