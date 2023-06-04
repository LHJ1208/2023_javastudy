package day25.com.ict.edu;

import java.io.File;
import java.io.IOException;

public class Ex02_File {
	public static void main(String[] args) {
		String pathname = "D:/LHJ/exam01.txt";
		File file = new File(pathname);
		try {
			boolean res = file.createNewFile();
			if (res) {
				System.out.println("파일 생성 성공");
			} else {
				System.out.println("파일 생성 실패(같은 이름의 파일이 존재)");
			}
			System.out.println("==============");
			System.out.println("절대경로 : " + file.getAbsolutePath());
			System.out.println("상대경로 : " + file.getPath());
			System.out.println("파일이름 : " + file.getName());
			System.out.println("==============");

			File file2 = new File("D:/LHJ/EXAMe/AAA");
			// 중간에 디렉토리가 하나라도 없으면 만들어지지 않는다.
			// boolean res2 = file2.mkdir();
			// 중간에 디렉토리가 없어도 만들어진다.
			boolean res2 = file2.mkdirs();
			if (res2) {
				System.out.println("디렉토리 생성 성공");
			} else {
				System.out.println("디렉토리 생성 실패(같은 이름의 디렉토리가 존재)");
			}

			// 파일 삭제
			String pathname2 = pathname;
			File file3 = new File(pathname2);
			boolean res3 = file3.delete();
			if (res3) {
				System.out.println("파일삭제 성공");
			} else {
				System.out.println("파일삭제 실패");
			}

			// 파일 삭제
			String pathname3 = "D:/LHJ/EXAMe/AAA";
			File file4 = new File(pathname3);
			boolean res4 = file4.delete();
			if (res4) {
				System.out.println("디렉토리 AAA 삭제 성공");
				File file5 = new File("D:/LHJ/EXAMe");
				boolean res5 = file5.delete();
				if (res5) {
					System.out.println("디렉토리 EXAMe 삭제 성공");
				} else {
					System.out.println("디렉토리 EXAMe 삭제 실패");
				}
			} else {
				System.out.println("디렉토리 AAA 삭제 실패");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
