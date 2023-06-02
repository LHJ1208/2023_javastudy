package day26.com.ict.team;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 텍스트 파일을 읽기 위한 class 입니다.
 * 입력값: filePath 에는 txt파일의 주소가 들어갑니다.
 * ex) D:/njm/test01.txt
 * 출력값: filePath에 해당 하는 txt파일의 내용이 담겨있는 String 변수를 반환합니다.
 * 		단, filePath에서 해당 txt파일을 못 읽은 경우 null 값을 반환합니다.
 * @author LHJ
 */
public class Team0531_ReadTextFile {
	static public String readTextFile(String filePath) {
		String result = null;
		
		String pathname = filePath;
		
		File f_source = new File(pathname);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream(f_source);
			bis = new BufferedInputStream(fis);

			byte[] bContents = new byte[(int) f_source.length()];
			bis.read(bContents);

			result = new String(bContents);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
			}
		}		
		
		return result;
	}
}
