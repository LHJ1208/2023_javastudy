package day26.com.ict.team;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex05_team {
	public static void team(String filePath, String text) {

		String pathname = filePath;
		File file = new File(pathname);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);

			String str = text;
			byte[] arr = str.getBytes();
			bos.write(arr);
			bos.flush();
		} catch (Exception e1) {
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (Exception e2) {
			}
		}
	}
}