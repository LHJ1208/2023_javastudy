package day28.com.ict.edu;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// ObjectInputStream : 객체 입력 스트림
// readObject() : 객체 역직렬화 메서드

public class Ex03_ObjectInputStream {
	public static void main(String[] args) {
		String pathName = "D:/njm/object.ser";
		File file = new File(pathName);

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			// 객체 역직렬화
			ArrayList<Ex03_VO> list = (ArrayList<Ex03_VO>) ois.readObject();

			for (Ex03_VO k : list) {
				System.out.print(k.getName() + " 님\t ");
				System.out.print(k.getAge() + "세\t ");
				System.out.print(k.getAddr() + " 거주\t ");
				System.out.print((k.isGender() ? "남성" : "여성") + "\t ");
				System.out.println(k.getHeight() + "cm");
			}
		} catch (Exception e) {
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (Exception e2) {
			}
		}
	}
}