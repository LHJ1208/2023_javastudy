package day26.com.ict.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// D:/njm/java1.png 읽어서 D:/njm/util/java1.png 쓰기(복사)
public class Ex04_File_IO {
	public static void main(String[] args) {
		String pn_source = "D:/njm/java1.png";
		String pn_target = "D:/njm/util/java1_1.png";

		File f_source = new File(pn_source);
		File f_target = new File(pn_target);

		FileInputStream fis = null;
		BufferedInputStream bis = null;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(f_source);
			bis = new BufferedInputStream(fis);

//			fos = new FileOutputStream(f_target, true);
			fos = new FileOutputStream(f_target);
			bos = new BufferedOutputStream(fos);

//			int res = 0;
//			while ((res = bis.read()) != -1) {
//				bos.write(res);
//			}

			byte[] b = new byte[(int) f_source.length()];
			bis.read(b);
			bos.write(b);
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
