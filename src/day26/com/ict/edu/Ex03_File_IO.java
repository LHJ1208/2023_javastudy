package day26.com.ict.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// D:/njm/test01.txt 읽어서 D:/njm/test02.txt 내용 추가
public class Ex03_File_IO {
	public static void main(String[] args) {
		String pn_source = "D:/njm/test01.txt";
		String pn_target = "D:/njm/test02.txt";

		File f_source = new File(pn_source);
		File f_target = new File(pn_target);

		FileInputStream fis = null;
		BufferedInputStream bis = null;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(f_source);
			bis = new BufferedInputStream(fis);

			fos = new FileOutputStream(f_target, true);
			bos = new BufferedOutputStream(fos);

			// 모든 파일의 복사, 이동은 해당 방식으로 해야 된다.
			int b = 0;
			while((b = bis.read()) != -1) {
				bos.write(b);
			}
			
//			byte[] b_contents = new byte[(int) f_source.length()];
//			bis.read(b_contents);
//			bos.write(b_contents);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();

				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
