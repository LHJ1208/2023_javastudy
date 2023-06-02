package day25.com.ict.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//바이트 출력 스트림 : OutputStream

//	자식클래스 FileOutputStream 사용해보기
//	FileOutputStream을 이용해서 해당 파일에 내용을 1byte 쓰기(출력, 저장)

//		주요 메서드 :
//			write(int b) : int => 숫자(아스키코드(0~255), 한 글자),
//				** 아스키코드(숫자, 대문자, 소문자, 일부 특수문자를 숫자와 1:1 매칭한 코드)

//			write(byte[] b) : 배열은 아스키코드의 배열이다.
//				** String 클래스에서 getByte()를 이용해서 byte[]로 만들어서 사용

//			flush() : 버퍼 내용이 채워지지 않아도 출력하게 만듬

//			close() : 출력 스트림 닫기

public class Ex04_OutputStream {
	public static void main(String[] args) {
		String pathname = "D:/LHJ/test01.txt";

		File file = new File(pathname);
		FileOutputStream fos = null;
		try {
			// 파일이 없으면 생성, 있으면 덮어쓰기 한다.
//			fos = new FileOutputStream(file);

			// 파일이 없으면 생성, 있으면 이어쓰기 한다.
			fos = new FileOutputStream(file, true);

			// 한 글자 쓰기 (1Byte 출력 = 아스키코드 1Byte)
			fos.write(97);
			fos.write(65);
			fos.write(49);
			fos.write('\n');
			fos.write('b');
			fos.write('o');
			fos.write('y');
			fos.write('\n');
			// 아스키 코드를 제외하고 사용 불가

			// 한글 입력하면 오류 발생
//			byte[] arr = {'h', 'e', 'l', 'l', 'o', '민', '국', '1', '2'};
			byte[] arr = { 'h', 'e', 'l', 'l', 'o', 'H', 'I', '1', '2', '\n' };
			fos.write(arr);

			String str = "Hello\n대한민국\n123456\n";
			byte[] arr2 = str.getBytes();
			fos.write(arr2);

			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
